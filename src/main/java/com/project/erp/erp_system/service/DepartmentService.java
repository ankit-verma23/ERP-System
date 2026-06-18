package com.project.erp.erp_system.service;

import com.project.erp.erp_system.dto.DepartmentResponse;
import com.project.erp.erp_system.dto.DepartmentRequest;
import com.project.erp.erp_system.entity.Department;
import com.project.erp.erp_system.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    private Department mapToEntity(DepartmentRequest request) {
        Department department = new Department();

        department.setName(request.getName());
        department.setDescription(request.getDescription());
        return department;
    }

    private DepartmentResponse mapToResponse(Department department) {
        DepartmentResponse departmenResponse = new DepartmentResponse();

        departmenResponse.setId(department.getId());
        departmenResponse.setName(department.getName());
        departmenResponse.setDescription(department.getDescription());
        return departmenResponse;
    }

    public DepartmentResponse createDepartment(DepartmentRequest request) {
        Department department = mapToEntity(request);
        Department savedDepartment = departmentRepository.save(department);
        return mapToResponse(savedDepartment);
    }

    public List<DepartmentResponse> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public DepartmentResponse getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow();

        return mapToResponse(department);
    }

    public DepartmentResponse updateDepartment(Long id, DepartmentRequest updateDepartment) {
        Department department = departmentRepository.findById(id).orElseThrow();
        department.setDescription(updateDepartment.getDescription());
        department.setName(updateDepartment.getName());
        Department updatedDepartment = departmentRepository.save(department);

        return mapToResponse(updatedDepartment);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
