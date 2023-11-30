package com.example.makeup;

public class MakeupSearchRequest {

    private String prefix;
    private String suffix;
    private String contains;

    public MakeupSearchRequest(String prefix, String suffix, String contains) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.contains = contains;
    }

    public String getPrefix() {
        return prefix == null ? "" : prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    //三項演算子を使って
    public String getSuffix() {
        return suffix == null ? "" : suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getContains() {
        return contains == null ? "" : contains;
    }

    public void setContains(String contains) {
        this.contains = contains;
    }

}
