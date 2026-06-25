package com.project.erp.erp_system.dto;

import com.project.erp.erp_system.enums.Designation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyResponse {
    private Long id;
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
