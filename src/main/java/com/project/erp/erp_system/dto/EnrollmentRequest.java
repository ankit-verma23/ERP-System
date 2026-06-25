package com.project.erp.erp_system.dto;

import com.project.erp.erp_system.enums.EnrollmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequest {
    private EnrollmentStatus status;
}
