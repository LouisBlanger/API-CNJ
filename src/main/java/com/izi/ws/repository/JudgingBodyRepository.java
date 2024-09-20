package com.izi.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.izi.ws.model.JudgingBody;

public interface JudgingBodyRepository extends JpaRepository<JudgingBody, Integer> {
    JudgingBody findByCaseId(int caseId);
}
