package com.izi.ws.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.criteria.CriteriaBuilder.Case;

public interface CaseRepository extends JpaRepository<Case, Integer> {

    Optional<Case> findByCaseId(Long id);

    boolean existsByCaseNumber(String caseNumber);

    @Query("SELECT c FROM Case c "
            + " LEFT JOIN ClientCase client on c.caseId = client.caseId "
            + " LEFT JOIN UserCase user on c.caseId = user.caseId "
            + "WHERE UPPER(c.caseNumber) LIKE CONCAT('%', UPPER(:caseNumber), '%') "
            + "and ((c.userIdCreated=:userId and restricted=1) or (restricted=0)) "
            + "and (user.userId in :userIds or 0 in :userIds) and (client.clientId in :clientIds or 0 in :clientIds) "
            + "and TO_DATE(TO_CHAR(c.inclusionDate, 'YYYY-MM-DD'), 'YYYY-MM-DD') between CAST(:startDate AS DATE) and CAST(:endDate AS DATE) "
            + "and c.status in :statuses order by c.caseId")
    List<Case> listCases(String caseNumber, int[] statuses, Date startDate,
            Date endDate, int userId, int[] clientIds, int[] userIds);

    List<Case> findByMonitoringIndicator(int monitoringIndicator);
}
