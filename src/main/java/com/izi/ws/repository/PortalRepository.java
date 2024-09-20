package com.izi.ws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.izi.ws.model.Portals;

public interface PortalRepository extends JpaRepository<Portals, Integer> {

    Optional<Portals> findById(Long id);

    Optional<Portals> findByLink(String link);
}
