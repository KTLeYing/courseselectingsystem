package com.mzl.model;

public class Institution {

    private int insId;
    private String insName;

    public void setInsId(int insId) {
        this.insId = insId;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public int getInsId() {
        return insId;
    }

    public String getInsName() {
        return insName;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "insId=" + insId +
                ", insName='" + insName + '\'' +
                '}';
    }
}
