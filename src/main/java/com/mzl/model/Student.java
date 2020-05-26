package com.mzl.model;

public class Student {

    private int stuId;
    private String stuPass;
    private String stuName;
    private int insId;
    private String insName;
    private int tempScore;

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public void setStuPass(String stuPass) {
        this.stuPass = stuPass;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setInsId(int insId) {
        this.insId = insId;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public void setTempScore(int tempScore) {
        this.tempScore = tempScore;
    }

    public int getStuId() {
        return stuId;
    }

    public String getStuPass() {
        return stuPass;
    }

    public String getStuName() {
        return stuName;
    }

    public int getInsId() {
        return insId;
    }

    public String getInsName() {
        return insName;
    }

    public int getTempScore() {
        return tempScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuPass='" + stuPass + '\'' +
                ", stuName='" + stuName + '\'' +
                ", insId=" + insId +
                ", insName='" + insName + '\'' +
                ", tempScore=" + tempScore +
                '}';
    }
}
