package com.mzl.service.impl;

import com.mzl.dao.CourseDao;
import com.mzl.dao.UserDao;
import com.mzl.model.*;
import com.mzl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<Course> queryAllCourse(int stuid) {
        List<Course> course_list = courseDao.queryAllCourse();
        List<Integer> stu_courselist = courseDao.queryCourseIdByStuId(stuid);
        for (Course c : course_list){
            c.setClassLimitInsName(new ArrayList<>());
            List<Integer> limit_list = courseDao.selectInsIdByClassId(c.getClassId());
            for (Integer i : limit_list){
                c.getClassLimitInsName().add(courseDao.selectNameByInsId(i));
            }
            c.setTeaName(courseDao.selectTeaNameByTeaId(c.getTeaId()));
            c.setIsChoose(0);
            for (int i : stu_courselist){
                if (c.getClassId() == i){
                    c.setIsChoose(1);
                    break;
                }
            }
        }
        return course_list;
    }

    @Override
    public List<Institution> queryAllIns() {
        return courseDao.queryAllIns();
    }

    @Override
    public boolean checkStuIns(int classId, int stuId) {
        int stu_insId = userDao.selectStuById(stuId).getInsId();
        List<Integer> class_insId = courseDao.queryInsIdByCourseId(classId);
        for (int i : class_insId){
            if (stu_insId == i){
                return true;
            }
        }
        return false;
    }

    @Override
    public Course queryCourse(int id) {
        Course course=courseDao.selectCourseByClassId(id);
        List<Integer> limit_list=courseDao.selectInsIdByClassId(id);
        course.setClassLimitInsName(new ArrayList<>());
        for(Integer i : limit_list){
            course.getClassLimitInsName().add(courseDao.selectNameByInsId(i));
        }
        course.setTeaName(courseDao.selectTeaNameByTeaId(course.getTeaId()));
        return course;
    }

    @Override
    public void chooseSuccess(int classId, int stuId) {
        courseDao.addChooseNum(classId);
        Course_choose course_choose = new Course_choose();
        course_choose.setScore(0);
        course_choose.setClassId(classId);
        course_choose.setStuId(stuId);
        courseDao.addCourseChoose(course_choose);
    }

    @Override
    public void deleteCourseChoose(int stuId, int classId) {
        courseDao.downChooseNum(classId);
        Course_choose course_choose = new Course_choose();
        course_choose.setStuId(stuId);
        course_choose.setClassId(classId);
        courseDao.deleteCourseChoose(course_choose);
    }

    @Override
    public List<Course> queryAllById(int id) {
        List<Course> course_list= courseDao.queryCourseById(id);
        for(Course c:course_list){
            c.setClassLimitInsName(new ArrayList<>());
            List<Integer> limit_list=courseDao.selectInsIdByClassId(c.getClassId());
            for(Integer i:limit_list){
                c.getClassLimitInsName().add(courseDao.selectNameByInsId(i));
            }
            c.setTeaName(courseDao.selectTeaNameByTeaId(c.getTeaId()));
        }
        return course_list;
    }

    @Override
    public List<Course> queryAllByInsId(int insId) {
        List<Course> course_list = courseDao.queryAllCourse();
        List<Course> course_Inslist = new ArrayList<>();
        for (Course c : course_list){
            List<Integer> limit_list = courseDao.selectInsIdByClassId(c.getClassId());
            for (int li : limit_list){
                if (insId == li){
                    course_Inslist.add(c);
                    break;
                }
            }
        }
        for (Course cc : course_Inslist){
            cc.setClassLimitInsName(new ArrayList<>());
            List<Integer> limit_list = courseDao.selectInsIdByClassId(cc.getClassId());
            for (Integer i : limit_list){
                cc.getClassLimitInsName().add(courseDao.selectNameByInsId(i));
            }
            cc.setTeaName(courseDao.selectTeaNameByTeaId(cc.getTeaId()));
        }
        return course_Inslist;
    }

    @Override
    public List<Course> queryStuCourse(Integer stuId) {
        List<Integer> classid_list = courseDao.queryCourseIdByStuId(stuId);
        System.out.println(classid_list);
        List<Course> course_list = new ArrayList<>();
        for (int i : classid_list){
            Course course = courseDao.queryCourseInfoById(i);
            System.out.println(course.getTeaId());
            System.out.println("jjjjj");
            course.setTeaName(courseDao.selectTeaNameByTeaId(course.getTeaId()));
            System.out.println("uuuuu");
            Course_choose course_choose = new Course_choose();
            course_choose.setClassId(i);
            course_choose.setStuId(stuId);
            System.out.println("qqqqq");
            course.setScore(courseDao.selectScore(course_choose));
            System.out.println("yyyyy");
            course_list.add(course);
        }
        System.out.println(course_list);
        return course_list;
    }

    @Override
    public int insertCourse(String name, String num, int teaid) {
        Course course=new Course();
        course.setClassName(name);
        course.setClassNum(Integer.parseInt(num));
        course.setClassChooseNum(0);
        course.setTeaId(teaid);
        courseDao.insertCourse(course);
        return course.getClassId();
    }

    @Override
    public void insertInsLimit(String det, int classId) {
        String[] insList=det.split(",");
        for(String in:insList){
            Course_limit course_limit=new Course_limit();
            course_limit.setClassId(classId);
            course_limit.setInsId(Integer.parseInt(in));
            courseDao.insertInsLimit(course_limit);
        }
    }

    @Override
    public Course queryInfoById(int id) {
        return courseDao.queryCourseInfoById(id);
    }

    @Override
    public List<Integer> selectCourseLimit(int classId) {
        return courseDao.selectInsIdByClassId(classId);
    }

    /*@Override
    public int updateCourse(String name,String num,int teaid, int courseid) {
        Course course=new Course();
        course.setTeaId(teaid);
        course.setClassChooseNum(courseDao.selectChooseNum(courseid));
//        course.setClassChooseNum(0);
        course.setClassNum(Integer.parseInt(num));
        course.setClassName(name);
//        course.setClassId(courseDao.selectMaxCourseId());
        courseDao.deleteCourse(courseid);
        courseDao.insertCourse(course);
//        courseDao.updateCourse(course);
        return course.getClassId();
    }*/

    @Override
    public int updateCourse(String name,String num,int teaid, int courseid) {
        Course course=new Course();
        course.setTeaId(teaid);
        course.setClassChooseNum(courseDao.selectChooseNum(courseid));
//        course.setClassChooseNum(0);
        course.setClassNum(Integer.parseInt(num));
        course.setClassName(name);
        course.setClassId(courseid);
//        course.setClassId(courseDao.selectMaxCourseId());
        courseDao.updateCourse(course);
        return courseid;
    }


    @Override
    public void updateInsLimit(String det, int classId) {
        String[] insList = det.split(",");
        courseDao.deleteInsLimit(classId);
        for(String ins:insList){
            Course_limit course_limit=new Course_limit();
            course_limit.setClassId(classId);
            course_limit.setInsId(Integer.parseInt(ins));
            courseDao.insertInsLimit(course_limit);
        }
    }

    @Override
    public void deleteCourse(int id) {
        courseDao.deleteCourse(id);
        //解除选课表关联
        courseDao.deleteStuByClassId(id);
        //解除学院限制表关联
        courseDao.deleteLimitByClassId(id);
    }

    @Override
    public List<Student> queryStuByCourseId(int id) {
        List<Student> stu_list = new ArrayList<>();
        List<Course_choose> id_list = courseDao.queryStuIdByCourseId(id);
        System.out.println(id_list);
        for (Course_choose i : id_list){
            Student student = userDao.selectStuById(i.getStuId());
            System.out.println(i.getStuId());
            student.setTempScore(i.getScore());
            stu_list.add(student);
        }
        System.out.println("yyyyy");
        return stu_list;
    }

    @Override
    public List<Student> queryStuByStuId(int classid, int stuid) {
        List<Student> stu_list = new ArrayList<>();
        List<Course_choose> id_list = courseDao.queryStuIdByCourseId(classid);
        for (Course_choose i : id_list){
            if (i.getStuId() == stuid){
                Student student = userDao.selectStuById(stuid);
                student.setTempScore(i.getScore());
                stu_list.add(student);
            }
        }
        return stu_list;
    }

    @Override
    public void updateScore(int classid, int stuid, int score) {
        Course_choose course_choose = new Course_choose();
        course_choose.setStuId(stuid);
        course_choose.setClassId(classid);
        course_choose.setScore(score);
        courseDao.updateScore(course_choose);
    }

    @Override
    public void deleteStuCourse(int classid, int stuid) {
        Course_choose course_choose = new Course_choose();
        course_choose.setClassId(classid);
        course_choose.setStuId(stuid);
        courseDao.deleteStuCourse(course_choose);
    }


}
