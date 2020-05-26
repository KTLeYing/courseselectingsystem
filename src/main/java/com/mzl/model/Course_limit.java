package com.mzl.model;

public class Course_limit {

    private int classId;
    private int insId;

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setInsId(int insId) {
        this.insId = insId;
    }

    public int getClassId() {
        return classId;
    }

    public int getInsId() {
        return insId;
    }

    @Override
    public String toString() {
        return "Course_limit{" +
                "classId=" + classId +
                ", insId=" + insId +
                '}';
    }
}
