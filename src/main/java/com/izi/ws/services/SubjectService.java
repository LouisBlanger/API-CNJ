package com.izi.ws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izi.ws.repository.SubjectProcessRepository;

import jakarta.transaction.Transactional;

@Service
public class SubjectService {

    @Autowired
    private SubjectProcessRepository repository;

    @Transactional
    public void deleteByProcessIdAndManualIndicator(int processId, int manualIndicator) {
        repository.deleteByProcessIdAndManualIndicator(processId, manualIndicator);
    }

    public void deleteSubject(int subjectId) {
        repository.deleteById(subjectId);
    }

}
