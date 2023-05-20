package com.experiment.service;

import com.experiment.mapper.CourseMapper;
import com.experiment.pojo.Course;
import com.experiment.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public void insertCourse(Course course, MultipartFile file) {
        if (file != null) {
            String originalFileName = file.getOriginalFilename();
            if (originalFileName.equals("")){
                course.setPicture("img1.jpg");
            } else {
                String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
                String fileName = UUID.randomUUID().toString() + suffix;
                String filePath = Constants.IMG_PATH + fileName;
                File saveFile = new File(filePath);
                try {
                    file.transferTo(saveFile);
                    course.setPicture(fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        courseMapper.insertCourse(course);
    }

    @Override
    public void updateCourse(Course course, MultipartFile file) {
        if (file != null) {
            String originalFileName = file.getOriginalFilename();
            if (!originalFileName.equals("")) {
                String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
                String fileName = UUID.randomUUID().toString() + suffix;
                String filePath = Constants.IMG_PATH + fileName;
                File saveFile = new File(filePath);
                try {
                    file.transferTo(saveFile);
                    course.setPicture(fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        courseMapper.updateCourse(course);
    }

    @Override
    public void deleteCourse(int id) {
        courseMapper.deleteCourse(id);
    }

    @Override
    public List<Course> findAllCourse() {
        return courseMapper.findAllCourse();
    }

    @Override
    public Course findCourse(String name) {
        return courseMapper.findCourseByName(name);
    }

    @Override
    public Course findCourse(int id) {
        return courseMapper.findCourseById(id);
    }
}
