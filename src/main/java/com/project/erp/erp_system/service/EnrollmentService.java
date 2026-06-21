package com.project.erp.erp_system.service;

import com.project.erp.erp_system.entity.Enrollment;
import com.project.erp.erp_system.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id).orElseThrow();
    }

    public List<Enrollment> getAllEnrollment() {
        return enrollmentRepository.findAll();
    }

    public Enrollment updateEnrollment(Long id, Enrollment update) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow();

        enrollment.setStatus(update.getStatus());

        return enrollmentRepository.save(enrollment);
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteAll();
    }
}
