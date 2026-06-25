package com.project.erp.erp_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String courseCode;
    private String courseName;
    private String description;
    private Integer semester;
}
