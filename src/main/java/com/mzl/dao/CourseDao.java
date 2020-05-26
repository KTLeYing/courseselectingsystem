package com.mzl.dao;

import com.mzl.model.Course;
import com.mzl.model.Course_choose;
import com.mzl.model.Course_limit;
import com.mzl.model.Institution;

import java.util.List;

public interface CourseDao {

    public List<Course> queryCourseById(int id);
    public List<Integer> selectInsIdByClassId(int classId);
    public String selectNameByInsId(int id);
    public List<Institution> queryAllIns();
    public List<Course> queryAllCourse();
    public List<Integer> queryCourseIdByStuId(int stuid);
    public String selectTeaNameByTeaId(int teaId);
    public List<Integer> queryInsIdByCourseId(int classId);
    public Course selectCourseByClassId(int classId);
    public void addChooseNum(int classId);
    public void addCourseChoose(Course_choose course_choose);
    public void downChooseNum(int classId);
    public void deleteCourseChoose(Course_choose course_choose);
    public Course queryCourseInfoById(int  id);
    public int selectScore(Course_choose course_choose);
    public void insertCourse(Course course);
    public void insertInsLimit(Course_limit course_limit);
    public int selectMaxCourseId();
    public void updateCourse(Course course);
    public void deleteInsLimit(int id);
    public void deleteCourse(int id);
    public int selectChooseNum(int id);
    public void deleteStuByClassId(int id);
    public void deleteLimitByClassId(int id);
    public List<Course_choose> queryStuIdByCourseId(int id);
    public void updateScore(Course_choose course_choose);
    public void deleteStuCourse(Course_choose course_choose);
}
