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

@Entity
@Table(name = "process_supplement")
public class ProcessSupplement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "process_id")
    private int processId;
    @Column(name = "movement_id")
    private int movementId;
    @Column(name = "inclusion_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date inclusionDate;
    @Column(name = "code")
    private int code;
    @Column(name = "value")
    private int value;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "type_indicator")
    private int typeIndicator;

    public ProcessSupplement() {

    }

    public ProcessSupplement(int id, int processId, Date inclusionDate, int code, int value, String name,
            String description, int movementId, int typeIndicator) {
        this.id = id;
        this.processId = processId;
        this.inclusionDate = inclusionDate;
        this.code = code;
        this.value = value;
        this.name = name;
        this.description = description;
        this.movementId = movementId;
        this.typeIndicator = typeIndicator;
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

    public Date getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(Date inclusionDate) {
        this.inclusionDate = inclusionDate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMovementId() {
        return movementId;
    }

    public void setMovementId(int movementId) {
        this.movementId = movementId;
    }

    public int getTypeIndicator() {
        return typeIndicator;
    }

    public void setTypeIndicator(int typeIndicator) {
        this.typeIndicator = typeIndicator;
    }
}
