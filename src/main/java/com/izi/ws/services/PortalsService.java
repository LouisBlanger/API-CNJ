package com.izi.ws.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izi.ws.model.Portals;
import com.izi.ws.repository.PortalRepository;

@Service
public class PortalsService {

    @Autowired
    private PortalRepository repository;

    public List<Portals> findAll() {
        List<Portals> portals = repository.findAll();
        return portals != null ? portals : Collections.emptyList(); // Return an empty list if the result is null
    }

    public List<Portals> listPortals() {
        return findAll(); // Reusing the findAll method to avoid duplication
    }

    public Portals findById(int id) {
        Optional<Portals> optionalPortal = repository.findById(id);
        return optionalPortal.orElse(null);
    }

    public Portals findByLink(String link) {
        Optional<Portals> optionalPortal = repository.findByLink(link);
        return optionalPortal.orElse(null);
    }
}
