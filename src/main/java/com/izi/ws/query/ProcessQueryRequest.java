package com.izi.ws.query;

public class ProcessQueryRequest {
    private Query query;

    public ProcessQueryRequest(String processNumber) {
        this.query = new Query(new Match(processNumber));
    }

    public static class Query {
        private Match match;

        public Query(Match match) {
            this.match = match;
        }

        public Match getMatch() {
            return match;
        }

        public void setMatch(Match match) {
            this.match = match;
        }
    }

    public static class Match {
        private String processNumber;

        public Match(String processNumber) {
            this.processNumber = processNumber;
        }

        public String getProcessNumber() {
            return processNumber;
        }

        public void setProcessNumber(String processNumber) {
            this.processNumber = processNumber;
        }
    }
}
