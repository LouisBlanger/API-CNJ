package com.izi.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.izi.ws.model.ProcessMovement;

public interface CaseMovementRepository extends JpaRepository<ProcessMovement, Integer> {

    List<ProcessMovement> findByCaseId(int caseId);

    List<ProcessMovement> findByCaseIdAndManualIndicator(int caseId, int manualIndicator);

    void deleteByCaseIdAndManualIndicator(int caseId, int manualIndicator);
}
