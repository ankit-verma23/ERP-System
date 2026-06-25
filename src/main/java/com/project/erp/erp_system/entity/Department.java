package com.project.erp.erp_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table (name = "Department")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Field can't be blank")
    private String name;
    @NotBlank(message = "Field can't be blank")
    private String description;

    @OneToMany(mappedBy = "department")
    private List<Student> student;

    @OneToMany(mappedBy = "department")
    private List<Faculty> faculty;

    @OneToMany(mappedBy = "department")
    private List<Course> course;
}
