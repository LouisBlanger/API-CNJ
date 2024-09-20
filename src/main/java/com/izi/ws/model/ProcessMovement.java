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
@Table(name = "process_movement")
public class ProcessMovement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "process_id")
    private int processId;
    @Column(name = "manual_indicator")
    private int manualIndicator;
    @Column(name = "notify_indicator")
    private int notifyIndicator;
    @Column(name = "code")
    private Integer code;
    @Column(name = "name")
    private String name;
    @Column(name = "date_time")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dateTime;
    @Transient
    private List<ComplementaryTable> complement;
    @Column(name = "user_id_created")
    private int userIdCreated;
    @Transient
    private String userCreated;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date inclusionDate;

    public ProcessMovement() {
    }

    public ProcessMovement(int id, int processId, int manualIndicator, Integer code, String name, Date dateTime,
            List<ComplementaryTable> complement, int userIdCreated, String userCreated, Date inclusionDate,
            int notifyIndicator) {
        this.id = id;
        this.processId = processId;
        this.manualIndicator = manualIndicator;
        this.code = code;
        this.name = name;
        this.dateTime = dateTime;
        this.complement = complement;
        this.userIdCreated = userIdCreated;
        this.userCreated = userCreated;
        this.inclusionDate = inclusionDate;
        this.notifyIndicator = notifyIndicator;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public List<ComplementaryTable> getComplement() {
        return complement;
    }

    public void setComplement(List<ComplementaryTable> complement) {
        this.complement = complement;
    }

    public int getUserIdCreated() {
        return userIdCreated;
    }

    public void setUserIdCreated(int userIdCreated) {
        this.userIdCreated = userIdCreated;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    public Date getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(Date inclusionDate) {
        this.inclusionDate = inclusionDate;
    }

    public int getManualIndicator() {
        return manualIndicator;
    }

    public void setManualIndicator(int manualIndicator) {
        this.manualIndicator = manualIndicator;
    }

    public int getNotifyIndicator() {
        return notifyIndicator;
    }

    public void setNotifyIndicator(int notifyIndicator) {
        this.notifyIndicator = notifyIndicator;
    }
}
