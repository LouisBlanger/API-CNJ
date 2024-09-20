package com.izi.ws.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "process")
public class Process implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int processId;

    @Column(name = "process_number")
    private String processNumber;

    @Column(name = "process_value")
    private Double processValue;

    @Column(name = "class")
    private String processClass;

    @Column(name = "system")
    private String system;

    @Column(name = "format")
    private String format;

    @Column(name = "court")
    private String court;

    @Column(name = "last_update_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date lastUpdateDate;

    @Column(name = "degree")
    private String degree;

    @Column(name = "filing_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date filingDate;

    @Column(name = "portal_id")
    private String portalId;

    @Column(name = "secrecy_level")
    private Integer secrecyLevel;

    @Transient
    private List<ProcessMovement> movements;

    @Transient
    private List<ProcessSubject> subjects;

    @Column(name = "inclusion_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date inclusionDate;

    @Column(name = "created_by_user_id")
    private int createdByUserId;

    @Column(name = "monitor_flag")
    private int monitorFlag;

    @Transient
    private String statusName;

    @Transient
    private String participants;

    @Transient
    private String clientsSummary;

    @Transient
    private String createdByUser;

    @Column(name = "restricted_flag")
    private int restrictedFlag;

    @Column(name = "status")
    private int status;

    public Process() {
    }

    public Process(int processId, String processNumber, String processClass, String system, String format,
            String court, Date lastUpdateDate, String degree, Date filingDate, String portalId,
            Integer secrecyLevel, List<ProcessMovement> movements,
            List<ProcessSubject> subjects, Date inclusionDate, int createdByUserId, String statusName,
            String participants, String clientsSummary,
            int restrictedFlag, int status, String createdByUser, Double processValue, int monitorFlag) {
        this.processId = processId;
        this.processNumber = processNumber;
        this.processClass = processClass;
        this.system = system;
        this.format = format;
        this.court = court;
        this.lastUpdateDate = lastUpdateDate;
        this.degree = degree;
        this.filingDate = filingDate;
        this.portalId = portalId;
        this.secrecyLevel = secrecyLevel;
        this.movements = movements;
        this.subjects = subjects;
        this.inclusionDate = inclusionDate;
        this.createdByUserId = createdByUserId;
        this.statusName = statusName;
        this.participants = participants;
        this.clientsSummary = clientsSummary;
        this.restrictedFlag = restrictedFlag;
        this.status = status;
        this.createdByUser = createdByUser;
        this.processValue = processValue;
        this.monitorFlag = monitorFlag;
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public String getProcessClass() {
        return processClass;
    }

    public void setProcessClass(String processClass) {
        this.processClass = processClass;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(Date filingDate) {
        this.filingDate = filingDate;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getPortalId() {
        return portalId;
    }

    public void setPortalId(String portalId) {
        this.portalId = portalId;
    }

    public Integer getSecrecyLevel() {
        return secrecyLevel;
    }

    public void setSecrecyLevel(Integer secrecyLevel) {
        this.secrecyLevel = secrecyLevel;
    }

    public List<ProcessMovement> getMovements() {
        return movements;
    }

    public void setMovements(List<ProcessMovement> movements) {
        this.movements = movements;
    }

    public List<ProcessSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<ProcessSubject> subjects) {
        this.subjects = subjects;
    }

    public Date getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(Date inclusionDate) {
        this.inclusionDate = inclusionDate;
    }

    public int getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(int createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public int getRestrictedFlag() {
        return restrictedFlag;
    }

    public void setRestrictedFlag(int restrictedFlag) {
        this.restrictedFlag = restrictedFlag;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getClientsSummary() {
        return clientsSummary;
    }

    public void setClientsSummary(String clientsSummary) {
        this.clientsSummary = clientsSummary;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Double getProcessValue() {
        return processValue;
    }

    public void setProcessValue(Double processValue) {
        this.processValue = processValue;
    }

    public int getMonitorFlag() {
        return monitorFlag;
    }

    public void setMonitorFlag(int monitorFlag) {
        this.monitorFlag = monitorFlag;
    }
}
