package com.project.erp.erp_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Field can't be blank")
    private String firstName;
    @NotBlank(message = "Field can't be blank")
    private String lastName;
//    @Size(min = 10, max = 10, message = "Phone number must contain 10 digits")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must contain exactly 10 digits"
    )
    private String phone;
    @NotBlank
    @Email(message = "Invalid email formate")
    private String email;
    @NotBlank(message = "Field can't be blank")
    private String course;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
}
