package com.mzl.service;

import com.mzl.model.Student;
import com.mzl.model.Teacher;

import java.util.List;

public interface UserService {

    public int checkAccount(int id, String pass);
    public String getTeaNameById(int id);
    public String getStuNameById(int id);
    public Student getStuInfoById(int id);
    public void changeStuPass(Student student);
    public List<Teacher> queryAllTeacher();
    public Teacher getTeaInfoById(int id);
    public void changeTeaPass(Teacher teacher);
}
