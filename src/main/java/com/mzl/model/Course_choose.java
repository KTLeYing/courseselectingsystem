package com.mzl.model;

public class Course_choose {

    private int chooseId;
    private int stuId;
    private int classId;
    private int score;

    public void setChooseId(int chooseId) {
        this.chooseId = chooseId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getChooseId() {
        return chooseId;
    }

    public int getStuId() {
        return stuId;
    }

    public int getClassId() {
        return classId;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Course_choose{" +
                "chooseId=" + chooseId +
                ", stuId=" + stuId +
                ", classId=" + classId +
                ", score=" + score +
                '}';
    }
}
