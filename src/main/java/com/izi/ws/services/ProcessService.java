package com.izi.ws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izi.ws.repository.CaseRepository;

@Service
public class ProcessService {

    @Autowired
    private CaseRepository repository;

}
