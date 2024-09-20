package com.izi.ws.model;

public class JudgingBody {
    private int municipalityCodeIBGE;
    private int code;
    private String name;

    public JudgingBody() {

    }

    public JudgingBody(int municipalityCodeIBGE, int code, String name) {
        this.municipalityCodeIBGE = municipalityCodeIBGE;
        this.code = code;
        this.name = name;
    }

    public int getMunicipalityCodeIBGE() {
        return municipalityCodeIBGE;
    }

    public void setMunicipalityCodeIBGE(int municipalityCodeIBGE) {
        this.municipalityCodeIBGE = municipalityCodeIBGE;
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
