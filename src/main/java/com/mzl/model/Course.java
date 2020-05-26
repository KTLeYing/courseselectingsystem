package com.mzl.model;

import java.util.List;

public class Course {

    private int classId;
    private String className;
    private int classNum;
    private int teaId;
    private String teaName;
    private int classChooseNum;
    private List<String> classLimitInsName;
    private int score;
    private int isChoose;

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public void setClassChooseNum(int classChooseNum) {
        this.classChooseNum = classChooseNum;
    }

    public void setClassLimitInsName(List<String> classLimitInsName) {
        this.classLimitInsName = classLimitInsName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setIsChoose(int isChoose) {
        this.isChoose = isChoose;
    }

    public int getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public int getClassNum() {
        return classNum;
    }

    public int getTeaId() {
        return teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public int getClassChooseNum() {
        return classChooseNum;
    }

    public List<String> getClassLimitInsName() {
        return classLimitInsName;
    }

    public int getScore() {
        return score;
    }

    public int getIsChoose() {
        return isChoose;
    }

    @Override
    public String toString() {
        return "Course{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classNum=" + classNum +
                ", teaId=" + teaId +
                ", teaName='" + teaName + '\'' +
                ", classChooseNum=" + classChooseNum +
                ", classLimitInsName=" + classLimitInsName +
                ", score=" + score +
                ", isChoose=" + isChoose +
                '}';
    }
}
