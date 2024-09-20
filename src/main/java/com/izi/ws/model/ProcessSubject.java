package com.izi.ws.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "assuntoprocesso")
public class ProcessSubject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "id_processo")
    private int processId;

    @Column(name = "codigo")
    private Integer code;

    @Column(name = "nome")
    private String name;

    @Column(name = "ind_tipo")
    private int manualIndicator;

    @Column(name = "id_user_create")
    private int createdByUserId;

    @Transient
    private String createdByUser;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date inclusionDate;

    public ProcessSubject() {
        // Default constructor
    }

    public ProcessSubject(int id, int processId, Integer code, String name, int manualIndicator, int createdByUserId,
            String createdByUser, Date inclusionDate) {
        this.id = id;
        this.processId = processId;
        this.code = code;
        this.name = name;
        this.manualIndicator = manualIndicator;
        this.createdByUserId = createdByUserId;
        this.createdByUser = createdByUser;
        this.inclusionDate = inclusionDate;
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

    public int getManualIndicator() {
        return manualIndicator;
    }

    public void setManualIndicator(int manualIndicator) {
        this.manualIndicator = manualIndicator;
    }

    public int getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(int createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Date getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(Date inclusionDate) {
        this.inclusionDate = inclusionDate;
    }
}
