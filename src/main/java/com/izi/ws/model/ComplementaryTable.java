package com.izi.ws.model;

public class ComplementaryTable {
    private int code;
    private int value;
    private String name;
    private String description;

    // Default constructor
    public ComplementaryTable() {

    }

    // Parameterized constructor
    public ComplementaryTable(int code, int value, String name, String description) {
        this.code = code;
        this.value = value;
        this.name = name;
        this.description = description;
    }

    // Getter for 'code'
    public int getCode() {
        return code;
    }

    // Setter for 'code'
    public void setCode(int code) {
        this.code = code;
    }

    // Getter for 'value'
    public int getValue() {
        return value;
    }

    // Setter for 'value'
    public void setValue(int value) {
        this.value = value;
    }

    // Getter for 'name'
    public String getName() {
        return name;
    }

    // Setter for 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Getter for 'description'
    public String getDescription() {
        return description;
    }

    // Setter for 'description'
    public void setDescription(String description) {
        this.description = description;
    }
}
