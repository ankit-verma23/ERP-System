package com.project.erp.erp_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "course")
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(max = 20)
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

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}
