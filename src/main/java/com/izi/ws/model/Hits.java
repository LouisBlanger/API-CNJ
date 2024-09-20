package com.izi.ws.model;

import java.util.List;

public class Hits {
    private Total total;
    private double max_score;
    private List<Hit> hits;

    public Hits() {

    }

    public Hits(Total total, double max_score, List<Hit> hits) {
        this.total = total;
        this.max_score = max_score;
        this.hits = hits;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public double getMax_score() {
        return max_score;
    }

    public void setMax_score(double max_score) {
        this.max_score = max_score;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

}
