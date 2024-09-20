package com.izi.ws.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izi.ws.model.ComplementaryTable;
import com.izi.ws.repository.TabulatedComplementRepository;

@Service
public class ComplementService {

    @Autowired
    private TabulatedComplementRepository repository;

    public List<ComplementaryTable> findByMovementId(int id) {
        List<ComplementaryTable> result = repository.findByMovementId(id);
        return result != null ? result : Collections.emptyList(); // Return an empty list if the result is null
    }
}
