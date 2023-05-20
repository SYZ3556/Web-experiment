package com.experiment.service;

import com.experiment.pojo.Course;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CourseService {
    public void insertCourse(Course course, MultipartFile file);
    public void updateCourse(Course course, MultipartFile file);
    public void deleteCourse(int id);
    public List<Course> findAllCourse();
    public Course findCourse(String name);
    public Course findCourse(int id);
}
