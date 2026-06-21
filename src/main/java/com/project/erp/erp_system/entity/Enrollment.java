package com.project.erp.erp_system.entity;

import com.project.erp.erp_system.enums.EnrollmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.collection.internal.StandardBagSemantics;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Enrollment")
public class Enrollment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime enrollmentDate;
    @Enumerated(EnumType.STRING)
    @NotNull
    private EnrollmentStatus status;
}
