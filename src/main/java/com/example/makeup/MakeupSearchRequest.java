package com.example.makeup;

public class MakeupSearchRequest {

    private String startsWith;
    private String endsWith;
    private String contains;

    public MakeupSearchRequest(String startsWith, String endsWith, String contains) {
        this.startsWith = startsWith;
        this.endsWith = endsWith;
        this.contains = contains;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public void setStartsWith(String startsWith) {
        this.startsWith = startsWith;
    }

    public String getEndsWith() {
        return endsWith;
    }

    public void setEndsWith(String endsWith) {
        this.endsWith = endsWith;
    }

    public String getContains() {
        return contains;
    }

    public void setContains(String contains) {
        this.contains = contains;
    }
}
