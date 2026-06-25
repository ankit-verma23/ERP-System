package com.project.erp.erp_system.service;

import com.project.erp.erp_system.dto.CourseRequest;
import com.project.erp.erp_system.dto.CourseResponse;
import com.project.erp.erp_system.entity.Course;
import com.project.erp.erp_system.repository.CourseRepository;
import com.project.erp.erp_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private Course mapToEntity(CourseRequest request) {
        Course course = new Course();
        course.setCourseCode(request.getCourseCode());
        course.setCourseName(request.getCourseName());
        course.setDescription(request.getDescription());
        course.setSemester(request.getSemester());
        return course;
    }

    private CourseResponse mapToResponse(Course course) {
        CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setCourseCode(course.getCourseCode());
        response.setCourseName(course.getCourseName());
        response.setDescription(course.getDescription());
        response.setSemester(course.getSemester());
        return response;
    }
    @Autowired
    private CourseRepository courseRepository;

    public CourseResponse createCourse(CourseRequest request) {
        Course course = mapToEntity(request);
        Course savedCourse = courseRepository.save(course);
        return mapToResponse(savedCourse);
    }

    public CourseResponse getcourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow();

        return mapToResponse(course);
    }

    public List<CourseResponse> getAllCourse() {

        return courseRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public CourseResponse updateCourse(Long id, CourseRequest update) {
        Course course = courseRepository.findById(id).orElseThrow();

        course.setCourseCode(update.getCourseCode());
        course.setCourseName(update.getCourseName());
        course.setDescription(update.getDescription());
        course.setSemester(update.getSemester());
        Course updatedCourse = courseRepository.save(course);
        return mapToResponse(updatedCourse);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
