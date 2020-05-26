package com.mzl.service.impl;

import com.mzl.dao.UserDao;
import com.mzl.model.Student;
import com.mzl.model.Teacher;
import com.mzl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int checkAccount(int id, String pass) {
        System.out.println("aaaaa");
        if (Integer.toString(id).charAt(4) == '1'){//教师
            System.out.println("jjjj");
            if (userDao.selectTeaById(id).getTeaPass().equals(pass)){
                System.out.println("ffff");
                return 2;
            }else {
                System.out.println("ffff");
                return 0;
            }
        }else {//学生
            System.out.println("bbbb");
            if (userDao.selectStuById(id).getStuPass().equals(pass)){
                System.out.println("oooo");
                return 1;
            }else {
                System.out.println("oooo");
                return 0;
            }
        }
    }

    @Override
    public String getTeaNameById(int id) {
        return userDao.selectTeaById(id).getTeaName();
    }

    @Override
    public String getStuNameById(int id) {
        return userDao.selectStuById(id).getStuName();
    }

    @Override
    public Student getStuInfoById(int id) {
        return userDao.selectStuById(id);
    }

    @Override
    public void changeStuPass(Student student) {
        userDao.updateStuPass(student);
    }

    @Override
    public List<Teacher> queryAllTeacher() {
        return userDao.queryAllTeacher();
    }

    @Override
    public Teacher getTeaInfoById(int id) {
        return userDao.selectTeaById(id);
    }

    @Override
    public void changeTeaPass(Teacher teacher) {
        userDao.updateTeaPass(teacher);
    }


}
