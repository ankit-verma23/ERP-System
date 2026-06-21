package com.project.erp.erp_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Course")
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Field can not be blank")
    private String courseCode;
    @NotBlank(message = "Field can not be blank")
    private String courseName;
    @NotBlank(message = "Field can not be blank")
    private String description;
    @NotNull(message = "Semester is required")
    @Min(1)
    @Max(8)
    private Integer semester;
}
