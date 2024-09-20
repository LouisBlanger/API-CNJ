package com.izi.ws.model;

public class ClassType {
    private int code;
    private String name;

    // Default constructor
    public ClassType() {
    }

    // Parameterized constructor
    public ClassType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getter for 'code'
    public int getCode() {
        return code;
    }

    // Setter for 'code'
    public void setCode(int code) {
        this.code = code;
    }

    // Getter for 'name'
    public String getName() {
        return name;
    }

    // Setter for 'name'
    public void setName(String name) {
        this.name = name;
    }
}
