package com.project.erp.erp_system.controller;

import com.project.erp.erp_system.dto.StudentRequest;
import com.project.erp.erp_system.dto.StudentResponse;
import com.project.erp.erp_system.entity.Student;
import com.project.erp.erp_system.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentResponse createStudent(@Valid @RequestBody StudentRequest student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequest updateStudent) {
        return studentService.updateStudent(id, updateStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
