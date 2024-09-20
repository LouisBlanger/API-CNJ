package com.izi.ws.model;

import java.util.Date;
import java.util.List;

public class Movement {
    private int code;
    private String name;
    private Date dateTime;
    private List<ComplementaryTable> structuredComplements;

    public Movement() {

    }

    public Movement(int code, String name, Date dateTime, List<ComplementaryTable> structuredComplements) {
        this.code = code;
        this.name = name;
        this.dateTime = dateTime;
        this.structuredComplements = structuredComplements;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public List<ComplementaryTable> getStructuredComplements() {
        return structuredComplements;
    }

    public void setStructuredComplements(List<ComplementaryTable> structuredComplements) {
        this.structuredComplements = structuredComplements;
    }
}
