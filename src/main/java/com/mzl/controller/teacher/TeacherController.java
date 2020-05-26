package com.mzl.controller.teacher;

import com.mzl.model.Course;
import com.mzl.model.Teacher;
import com.mzl.service.CourseService;
import com.mzl.service.PageService;
import com.mzl.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    @Resource
    private UserService userService;
    @Resource
    private PageService pageService;
    @Resource
    private CourseService courseService;

    @RequestMapping("/teacherIndex")
    public String teacherIndex(){
        return "teacher/teacherIndex";
    }

    @RequestMapping("/teacherInfo")
    public String teacherInfo(@RequestParam("teaid") int id, Model model){
        model.addAttribute("teacher", userService.getTeaInfoById(id));
        return "teacher/teacherInfo";
    }

    @RequestMapping("/editTeaPass")
    public String editTeaPass(){
        return "teacher/editTeaPass";
    }

    @RequestMapping("/changeTeaPass")
    public String changeTeaPass(@RequestParam("prepass") String prepass, @RequestParam("nowpass") String nowpass, Model model, HttpServletRequest request){
        int id = (int) request.getSession().getAttribute("teaid");
        if (userService.checkAccount(id, prepass) == 0){
            model.addAttribute("msg", "原始密码输入错误!");
            return "teacher/editTeaPass";
        }else {
            Teacher teacher = new Teacher();
            teacher.setTeaPass(nowpass);
            teacher.setTeaId(id);
            userService.changeTeaPass(teacher);
            model.addAttribute("teacher", userService.getTeaInfoById(id));
            return "teacher/teacherInfo";
        }
    }

    @RequestMapping("/courseList")
    public String courseList(@RequestParam("page") int page, Model model, HttpServletRequest request){
        model.addAttribute("paging", pageService.subList(page, courseService.queryAllById((Integer) request.getSession().getAttribute("teaid"))));
        return "teacher/courseList";
    }

    @RequestMapping("/insertCourse")
    public String insertCourse(Model model){
        model.addAttribute("insList",courseService.queryAllIns());
        return "teacher/insertCourse";
    }

    @RequestMapping("/insertCourseSuccess")
    public String insertCourseSuccess(@Param("content") String content, @Param("page") int page, Model model, HttpServletRequest request)throws UnsupportedEncodingException{
        String[] det= URLDecoder.decode(URLDecoder.decode(content,"utf-8"),"utf-8").split("\\|");
        System.out.println(det[0]+" "+det[1]+" "+det[2]);
        //获取插入后的课程编号
        int courseId=courseService.insertCourse(det[0],det[1],(int)request.getSession().getAttribute("teaid"));
        courseService.insertInsLimit(det[2],courseId);
        model.addAttribute("paging",pageService.subList(page,courseService.queryAllById((int)request.getSession().getAttribute("teaid"))));
        return "teacher/courseList";
    }

    @RequestMapping("/editCourse")
    public String editCourse(@RequestParam("courseid") int courseid, Model model, HttpServletRequest request){
        model.addAttribute("courseInfo",courseService.queryInfoById(courseid));
        model.addAttribute("checkIns", courseService.selectCourseLimit(courseid));
        model.addAttribute("insList", courseService.queryAllIns());
//        model.addAttribute("courseid1", courseid);
        request.getSession().setAttribute("courseid", courseid);
        return "teacher/editCourse";

    }

    @RequestMapping("/updateCourseSuccess")
    public String updateCourseSuccess(@Param("content") String content,@Param("page") int page, Model model, HttpServletRequest request)throws UnsupportedEncodingException{
        String[] det = URLDecoder.decode(URLDecoder.decode(content,"utf-8"),"utf-8").split("\\|");
        System.out.println(det[0] + " "+det[1] + " " + det[2]);
//        System.out.println("****************************");
//        System.out.println(request.getSession().getAttribute("courseid1"));
        int courseId0 = (int) request.getSession().getAttribute("courseid");
        int courseId = courseService.updateCourse(det[0],det[1],(int)request.getSession().getAttribute("teaid"), courseId0);
        System.out.println(det[2]);
        courseService.updateInsLimit(det[2],courseId);
        model.addAttribute("paging",pageService.subList(page,courseService.queryAllById((int)request.getSession().getAttribute("teaid"))));
        return "teacher/courseList";
    }

    @RequestMapping("/deleteCourse")
    public String deleteCourse(@Param("courseid") int courseid, Model model, HttpServletRequest request){
        courseService.deleteCourse(courseid);
        model.addAttribute("paging",pageService.subList(1,courseService.queryAllById((int)request.getSession().getAttribute("teaid"))));
        return "teacher/courseList";
    }

    @RequestMapping("/detailCourse")
    public String detailCourse(@Param("courseid") int courseid,@Param("page") int page, Model model,HttpServletRequest request){
        model.addAttribute("paging", pageService.subList(page,courseService.queryStuByCourseId(courseid)));
        System.out.println(pageService.subList(page,courseService.queryStuByCourseId(courseid)));
        return "teacher/courseDetail";
    }

    @RequestMapping("/searchStu")
    public String searchStu(@RequestParam("stuid") int stuid, @RequestParam("courseid") int courseid, Model model){
        model.addAttribute("paging", pageService.subList(1, courseService.queryStuByStuId(courseid, stuid)));
        return "teacher/courseDetail";
    }

    @RequestMapping("/updateScore")
    public String updateScore(@Param("stuid") int stuid, @Param("courseid") int courseid, @Param("score") int score, @Param("page") int page, Model model) {
        courseService.updateScore(courseid, stuid, score);
        model.addAttribute("paging", pageService.subList(page,courseService.queryStuByCourseId(courseid)));
        return "teacher/courseDetail";
    }

    @RequestMapping("/deleteStuCourse")
    public String deleteStuCourse(@Param("courseid") int courseid, @Param("stuid") int stuid, Model model){
        courseService.deleteStuCourse(courseid, stuid);
        model.addAttribute("paging", pageService.subList(1, courseService.queryStuByCourseId(courseid)));
        return "teacher/courseDetail";
    }


}
