package com.izi.ws.model;

public class Total {
    private int value;
    private String relation;

    public Total() {
    }

    public Total(int value, String relation) {
        this.value = value;
        this.relation = relation;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
