package com.izi.ws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izi.ws.model.ProcessMovement;
import com.izi.ws.repository.CaseMovementRepository;

@Service
public class MovementService {

    @Autowired
    private CaseMovementRepository repository;

    public ProcessMovement editMovement(ProcessMovement request) {
        return repository.save(request);
    }

    public void deleteMovement(int annotationId) {
        repository.deleteById(annotationId);
    }
}
