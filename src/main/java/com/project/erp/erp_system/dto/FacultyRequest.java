package com.project.erp.erp_system.dto;

import com.project.erp.erp_system.enums.Designation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FacultyRequest {
    private String facultyCode;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Designation designation;
    private String qualification;
    private LocalDate joiningDate;
    private BigDecimal salary;
}
