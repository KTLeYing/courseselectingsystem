package com.mzl.service;

import com.mzl.model.Course;
import com.mzl.model.Institution;
import com.mzl.model.Student;

import java.util.List;

/**
 * @author 21989
 */
public interface CourseService {

    public List<Course> queryAllCourse(int stuid);
    public List<Institution> queryAllIns();
    public boolean checkStuIns(int classId,int stuId);
    public Course queryCourse(int classId);
    public void chooseSuccess(int classId, int stuId);
    public void deleteCourseChoose(int stuId,int classId);
    public List<Course> queryAllById(int teaId);
    public List<Course> queryAllByInsId(int insId);
    public List<Course> queryStuCourse(Integer stuId);
    public int insertCourse(String name, String num, int teaid);
    public void insertInsLimit(String det, int classId);
    public Course queryInfoById(int id);
    public List<Integer> selectCourseLimit(int classId);
    public int updateCourse(String name, String num, int teaid, int courseid);
    public void updateInsLimit(String det, int classId);
    public void deleteCourse(int id);
    public List<Student> queryStuByCourseId(int id);
    public List<Student> queryStuByStuId(int classid, int stuid);
    public void updateScore(int classid, int stuid, int score);
    public void deleteStuCourse(int classid, int stuid);
}
