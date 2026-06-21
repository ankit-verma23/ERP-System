package com.project.erp.erp_system.service;

import com.project.erp.erp_system.entity.Course;
import com.project.erp.erp_system.repository.CourseRepository;
import com.project.erp.erp_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getcourseById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public Course updateCourse(Long id, Course update) {
        Course course = courseRepository.findById(id).orElseThrow();

        course.setCourseCode(update.getCourseCode());
        course.setCourseName(update.getCourseName());
        course.setDescription(update.getDescription());
        course.setSemester(update.getSemester());

        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
