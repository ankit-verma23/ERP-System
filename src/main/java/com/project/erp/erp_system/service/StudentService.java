package com.project.erp.erp_system.service;

import com.project.erp.erp_system.dto.DepartmentResponse;
import com.project.erp.erp_system.dto.StudentRequest;
import com.project.erp.erp_system.dto.StudentResponse;
import com.project.erp.erp_system.entity.Student;
import com.project.erp.erp_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    private Student mapToEntity(StudentRequest request) {

        Student student = new Student();

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setCourse(request.getCourse());

        return student;
    }

    private StudentResponse mapToResponse(Student student) {

        StudentResponse response = new StudentResponse();

        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        response.setPhone(student.getPhone());
        response.setCourse(student.getCourse());

        return response;
    }

    public StudentResponse createStudent(StudentRequest request) {
        Student student = mapToEntity(request);
        Student savedStudent = studentRepository.save(student);
        return mapToResponse(savedStudent);
    }

    public List<StudentResponse> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        return mapToResponse(student);
    }

    public StudentResponse updateStudent(Long id, StudentRequest updateStudent) {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setFirstName(updateStudent.getFirstName());
        student.setLastName(updateStudent.getLastName());
        student.setEmail(updateStudent.getEmail());
        student.setPhone(updateStudent.getPhone());
        student.setCourse(updateStudent.getCourse());

        Student updatedStudent = studentRepository.save(student);
        return mapToResponse(updatedStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
