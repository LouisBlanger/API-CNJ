package com.izi.ws.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "judging_authority_process")
public class JudgingAuthorityProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "process_id")
    private int processId;
    @Column(name = "municipality_ibge_code")
    private Integer municipalityIBGECode;
    @Column(name = "code")
    private Integer code;
    @Column(name = "name")
    private String name;

    public JudgingAuthorityProcess() {
    }

    public JudgingAuthorityProcess(Integer municipalityIBGECode, Integer code, String name, int id, int processId) {
        this.municipalityIBGECode = municipalityIBGECode;
        this.code = code;
        this.name = name;
        this.id = id;
        this.processId = processId;
    }

    public Integer getMunicipalityIBGECode() {
        return municipalityIBGECode;
    }

    public void setMunicipalityIBGECode(Integer municipalityIBGECode) {
        this.municipalityIBGECode = municipalityIBGECode;
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
}
