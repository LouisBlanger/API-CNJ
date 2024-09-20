package com.izi.ws.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.izi.ws.model.Hit;
import com.izi.ws.model.Hits;
import com.izi.ws.model.Portals;
import com.izi.ws.model.ProcessMovement;
import com.izi.ws.model.SearchResult;
import com.izi.ws.model.Source;
import com.izi.ws.model.Subject;
import com.izi.ws.query.ProcessQueryRequest;
import com.izi.ws.services.PortalsService;
import com.izi.ws.services.ProcessService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProcessRest {
    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private PortalsService portalsService;

    @Autowired
    private ProcessService processService;

    @PostMapping("/processQuery")
    public List<Process> queryProcesses(@RequestBody(required = false) Map<String, String> filters)
            throws ParseException {

        List<Process> processList = new ArrayList<>();
        String processNumber = filters.get("number");
        String portalAlias = filters.get("alias");
        String processId = filters.get("processId");

        Portals portal = portalsService.findByAlias(portalAlias);

        // Building the request object
        ProcessQueryRequest request = new ProcessQueryRequest(processNumber);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "APIKey " + apiKeyValue);
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody;

        try {
            // Converting the object to JSON with Jackson
            requestBody = objectMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert request to JSON", e);
        }

        ResponseEntity<SearchResult> response = restTemplate.exchange(
                portal.getLink(),
                HttpMethod.POST,
                new HttpEntity<>(requestBody, headers),
                SearchResult.class);

        SearchResult searchResult = response.getBody();
        if (searchResult != null) {
            Hits hits = searchResult.getHits();
            if (hits != null) {
                List<Source> sources = hits.getHits().stream()
                        .map(Hit::get_source)
                        .collect(Collectors.toList());

                for (Source source : sources) {
                    Process process = new Process();

                    // If processId is present, fetch the process manually
                    if (processId != null && !processId.isEmpty()) {
                        process = processService.findById(Long.parseLong(processId));
                    }

                    process.setProcessNumber(source.getProcessNumber());
                    process.setClassName(source.getClassName().getName());
                    process.setSystemName(source.getSystem().getName());
                    process.setFormatName(source.getFormat().getName());
                    process.setCourt(source.getCourt());
                    process.setLastUpdate(source.getLastUpdate());
                    process.setDegree(source.getDegree());
                    process.setFilingDate(source.getFilingDate());
                    process.setConfidentialityLevel(source.getConfidentialityLevel());
                    process.setPortalId(String.valueOf(portal.getId()));

                    List<ProcessMovement> movementProcessList = createMovementProcesses(source.getMovements(),
                            processId);
                    process.setMovements(movementProcessList);

                    JudgingBodyProcess judgingBodyProcess = createJudgingBodyProcess(source.getJudgingBody());
                    process.setJudgingBody(judgingBodyProcess);

                    List<Subject> subjectProcessList = createSubjectProcesses(source.getSubjects(), processId);
                    process.setSubjects(subjectProcessList);

                    processList.add(process);
                }
            }
        }
        return processList;
    }

    public static Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        return dateFormat.parse(dateString);
    }
}
