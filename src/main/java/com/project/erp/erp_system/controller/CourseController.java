package com.project.erp.erp_system.controller;

import com.project.erp.erp_system.dto.CourseRequest;
import com.project.erp.erp_system.dto.CourseResponse;
import com.project.erp.erp_system.entity.Course;
import com.project.erp.erp_system.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public CourseResponse createCourse(@Valid @RequestBody CourseRequest course) {
        return courseService.createCourse(course);
    }

    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable Long id) {
        return courseService.getcourseById(id);
    }

    @GetMapping
    public List<CourseResponse> getAllCourse() {
        return courseService.getAllCourse();
    }

    @PutMapping("/{id}")
    public CourseResponse updateCourse(@PathVariable Long id, @Valid @RequestBody CourseRequest course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/id")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
