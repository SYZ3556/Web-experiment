package com.experiment.controller;

import com.experiment.pojo.Course;
import com.experiment.pojo.User;
import com.experiment.service.CourseService;
import com.experiment.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/showAllCourses")
    public String showAllCourses(HttpServletRequest request) {
        List<Course> courses = courseService.findAllCourse();
        request.setAttribute("courses", courses);
        request.setAttribute("username", User.name);
        return "course";
    }

    @RequestMapping("/toAddCourse")
    public String toAddCourse() {
        return "addCourse";
    }

    @RequestMapping("/addCourse")
    public String addCourse(Course course, @RequestParam("imgFile") MultipartFile file){
        Course exist = courseService.findCourse(course.getName());
        if (exist == null) {
            courseService.insertCourse(course, file);
        }
        return "redirect:/showAllCourses";
    }

    @RequestMapping("/toUpdateCourse")
    public String toUpdateCourse(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Course course = courseService.findCourse(id);
        request.setAttribute("course", course);
        return "updateCourse";
    }

    @RequestMapping("/updateCourse")
    public String updateCourse(Course course, @RequestParam("imgFile") MultipartFile file) {
        Course before = courseService.findCourse(course.getId());
        if (before.getName().equals(course.getName())) {
            courseService.updateCourse(course, file);
        } else {
            Course exist = courseService.findCourse(course.getName());
            if (exist == null) {
                courseService.updateCourse(course, file);
            }
        }
        return "redirect:showAllCourses";
    }

    @RequestMapping("/deleteCourse")
    public String deleteCourse(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        courseService.deleteCourse(id);
        return "redirect:showAllCourses";
    }

    @RequestMapping("/showPicture/{fileName}.{suffix}")
    public void showPicture(@PathVariable("fileName") String fileName, @PathVariable("suffix") String suffix, HttpServletResponse response) {
        File imgFile = new File(Constants.IMG_PATH + fileName + "." + suffix);
        responseFile(response, imgFile);
    }

    public void responseFile(HttpServletResponse response, File imgFile) {
        try (InputStream is = new FileInputStream(imgFile); OutputStream os = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            while(is.read(buffer) != -1) {
                os.write(buffer);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
