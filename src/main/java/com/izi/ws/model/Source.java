package com.izi.ws.model;

import java.util.Date;
import java.util.List;

public class Source {
    private String caseNumber;
    private ClassType classType;
    private System system;
    private Format format;
    private String court;
    private Date lastUpdateDateTime;
    private String level;
    private Date filingDate;
    private List<Movement> movements;
    private String id;
    private int confidentialityLevel;
    private JudgingBody judgingBody;
    private List<Subject> subjects;

    public Source() {

    }

    public Source(String caseNumber, ClassType classType, System system, Format format, String court,
            Date lastUpdateDateTime, String level, Date filingDate, List<Movement> movements, String id,
            int confidentialityLevel, JudgingBody judgingBody, List<Subject> subjects) {
        this.caseNumber = caseNumber;
        this.classType = classType;
        this.system = system;
        this.format = format;
        this.court = court;
        this.lastUpdateDateTime = lastUpdateDateTime;
        this.level = level;
        this.filingDate = filingDate;
        this.movements = movements;
        this.id = id;
        this.confidentialityLevel = confidentialityLevel;
        this.judgingBody = judgingBody;
        this.subjects = subjects;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public Date getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Date lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(Date filingDate) {
        this.filingDate = filingDate;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getConfidentialityLevel() {
        return confidentialityLevel;
    }

    public void setConfidentialityLevel(int confidentialityLevel) {
        this.confidentialityLevel = confidentialityLevel;
    }

    public JudgingBody getJudgingBody() {
        return judgingBody;
    }

    public void setJudgingBody(JudgingBody judgingBody) {
        this.judgingBody = judgingBody;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
