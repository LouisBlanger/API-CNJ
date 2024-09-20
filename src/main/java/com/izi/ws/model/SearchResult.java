package com.izi.ws.model;

public class SearchResult {
    private int took;
    private boolean timed_out;
    private Shards shards;
    private Hits hits;

    public SearchResult() {
    }

    public SearchResult(int took, boolean timed_out, Shards shards, Hits hits) {
        this.took = took;
        this.timed_out = timed_out;
        this.shards = shards;
        this.hits = hits;
    }

    public int getTook() {
        return took;
    }

    public void setTook(int took) {
        this.took = took;
    }

    public boolean isTimed_out() {
        return timed_out;
    }

    public void setTimed_out(boolean timed_out) {
        this.timed_out = timed_out;
    }

    public Shards getShards() {
        return shards;
    }

    public void setShards(Shards shards) {
        this.shards = shards;
    }

    public Hits getHits() {
        return hits;
    }

    public void setHits(Hits hits) {
        this.hits = hits;
    }

}
