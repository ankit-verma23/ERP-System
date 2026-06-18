package com.project.erp.erp_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String course;

}
