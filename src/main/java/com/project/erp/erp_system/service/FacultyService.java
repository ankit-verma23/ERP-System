package com.project.erp.erp_system.service;

import com.project.erp.erp_system.entity.Faculty;
import com.project.erp.erp_system.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElseThrow();
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public Faculty updateFaculty(Long id, Faculty update) {
        Faculty faculty = facultyRepository.findById(id).orElseThrow();

        faculty.setFacultyCode(update.getFacultyCode());
        faculty.setFirstName(update.getFirstName());
        faculty.setLastName(update.getLastName());
        faculty.setEmail(update.getEmail());
        faculty.setPhone(update.getPhone());
        faculty.setDesignation(update.getDesignation());
        faculty.setQualification(update.getQualification());
        faculty.setJoiningDate(update.getJoiningDate());
        faculty.setSalary(update.getSalary());

        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}
