package com.project.erp.erp_system.dto;

import com.project.erp.erp_system.enums.EnrollmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponse {
    private Long id;
    private LocalDateTime enrollmentDate;
    private EnrollmentStatus status;
}
