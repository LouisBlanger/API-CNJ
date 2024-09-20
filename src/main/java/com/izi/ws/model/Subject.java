package com.izi.ws.model;

public class Subject {
    private int code;
    private String name;

    public Subject() {
        // Default constructor
    }

    public Subject(int code, String name) {
        this.code = code;
        this.name = name;
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
}
