package com.mzl.dao;

import com.mzl.model.Student;
import com.mzl.model.Teacher;

import java.util.List;

public interface UserDao {

    public Student selectStuById(int id);
    public Teacher selectTeaById(int id);
    public void updateStuPass(Student student);
    public List<Teacher> queryAllTeacher();
    public void updateTeaPass(Teacher teacher);
}
