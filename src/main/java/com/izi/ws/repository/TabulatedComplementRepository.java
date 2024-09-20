package com.izi.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.izi.ws.model.ComplementaryTable;

public interface TabulatedComplementRepository extends JpaRepository<ComplementaryTable, Integer> {
    List<ComplementaryTable> findByMovementId(int movementId);
}
