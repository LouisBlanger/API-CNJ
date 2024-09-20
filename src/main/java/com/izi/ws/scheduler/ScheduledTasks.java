package com.izi.ws.scheduler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.izi.ws.model.ComplementaryTable;
import com.izi.ws.model.Hit;
import com.izi.ws.model.Hits;
import com.izi.ws.model.Movement;
import com.izi.ws.model.MovementProcess;
import com.izi.ws.model.Portal;
import com.izi.ws.model.ProcessMovement;
import com.izi.ws.model.SearchResult;
import com.izi.ws.model.Source;
import com.izi.ws.model.UserProcess;
import com.izi.ws.services.ComplementService;
import com.izi.ws.services.MovementService;
import com.izi.ws.services.PortalsService;
import com.izi.ws.services.ProcessService;

@Component
@EnableScheduling
public class ScheduledTasks {
    @Autowired
    private ProcessService processService;
    @Autowired
    private PortalsService portalService;

    @Autowired
    private MovementService movementService;

    @Autowired
    private ComplementService complementService;

    @Value("${apiKey}")
    private String apiKey;

    public void executeScheduledTaskMonitorProcess() {
        List<Process> processes = processService.findByMonitorIndicator();
        Date currentDate = new Date();
        Date lastExecutionTime = calculateLastExecutionTime(currentDate, 2);

        for (Process process : processes) {
            Portal portal = portalService.findById(Integer.parseInt(process.getId()));
            List<UserProcess> userProcesses = userProcessService.findByProcessId(process.getProcessId());
            process.setUserProcess(userProcesses);

            String requestBody = createJsonRequest(process.getProcessNumber());
            ResponseEntity<SearchResult> responseEntity = sendApiRequest(portal.getLink(), requestBody);

            if (responseEntity.getBody() != null) {
                processApiResponse(responseEntity.getBody(), process, lastExecutionTime);
            }
        }
    }

    private Date calculateLastExecutionTime(Date currentDate, int hoursToSubtract) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.HOUR_OF_DAY, -hoursToSubtract);
        return calendar.getTime();
    }

    private String createJsonRequest(String processNumber) {
        return String.format("{\"query\":{\"match\":{\"processNumber\":\"%s\"}}}", processNumber);
    }

    private ResponseEntity<SearchResult> sendApiRequest(String url, String requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "APIKey " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(requestBody, headers), SearchResult.class);
    }

    private void processApiResponse(SearchResult searchResult, Process process, Date lastExecutionTime) {
        Hits hits = searchResult.getHits();
        if (hits != null) {
            List<Source> sources = hits.getHits().stream()
                    .map(Hit::getSource)
                    .collect(Collectors.toList());
            for (Source source : sources) {
                List<Movement> movements = source.getMovements();
                List<MovementProcess> newMovementProcesses = extractNewMovements(movements, lastExecutionTime);
                process.setMovements(newMovementProcesses);
                saveMovementsAndNotifyUsers(process, newMovementProcesses);
            }
        }
    }

    private List<ProcessMovement> extractNewMovements(List<Movement> movements, Date lastExecutionTime) {
        List<ProcessMovement> newMovementProcesses = new ArrayList<>();
        for (Movement movement : movements) {
            ProcessMovement movementProcess = new ProcessMovement();
            movementProcess.setCode(movement.getCode());
            movementProcess.setDateTime(movement.getDateTime());
            movementProcess.setName(movement.getName());

            if (movementProcess.getDateTime().after(lastExecutionTime)) {
                newMovementProcesses.add(movementProcess);
            }
        }
        return newMovementProcesses;
    }

    private void saveMovementsAndNotifyUsers(Process process, List<ProcessMovement> newMovementProcesses) {
        for (ProcessMovement movementProcess : newMovementProcesses) {
            if (movementProcess.getManualIndicator() != 1) {
                ProcessMovement savedMovement = movementService.insert(movementProcess);
                saveComplementProcesses(movementProcess, savedMovement.getId());
                notifyUsers(process, savedMovement);
            }
        }
    }

    private void saveComplementProcesses(ProcessMovement movementProcess, int movementId) {
        if (movementProcess.getComplement() != null) {
            for (ComplementaryTable complement : movementProcess.getComplement()) {
                complement.setMovementId(movementId);
                complementService.insert(complement);
            }
        }
    }

    private void notifyUsers(Process process, ProcessMovement savedMovement) {
        String formattedDate = emailService.formatDateAndTimeOracle(savedMovement.getDateTime());
        for (UserProcess userProcess : process.getUserProcess()) {
            Notification notification = new Notification();
            notification.setTitle("NEW MOVEMENT Process: " + process.getProcessNumber());
            notification.setDescription("Date/Time: " + formattedDate + " Description: " + savedMovement.getName());
            notification.setUserIdCreated(userProcess.getUserId());
            notificationService.insert(notification);
        }
    }
}
