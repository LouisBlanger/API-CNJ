package com.izi.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.izi.ws.model.Subject;

public interface SubjectProcessRepository extends JpaRepository<Subject, Integer> {

    List<Subject> findByProcessId(int processId);

    List<Subject> findByProcessIdAndManualIndicator(int processId, int manualIndicator);

    void deleteByProcessIdAndManualIndicator(int processId, int manualIndicator);
}
