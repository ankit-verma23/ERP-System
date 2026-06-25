package com.project.erp.erp_system.entity;

import com.project.erp.erp_system.enums.Designation;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "Faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Field can not be blank")
    private String facultyCode;
    @NotBlank(message = "Field can not be blank")
    private String firstName;
    @NotBlank(message = "Field can not be blank")
    private String lastName;
    @Column(unique = true)
    @NotBlank
    @Email(message = "Invalid email formate")
    private String email;
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must contain exactly 10 digits"
    )
    private String phone;
    @NotNull (message = "Feild can not be blank")
    @Enumerated(EnumType.STRING)
    private Designation designation;
    @NotBlank(message = "Feild can not be blank")
    private String qualification;
    private LocalDate joiningDate;
    @NotNull
    @Positive
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "faculty")
    private List<Course> course;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;


}
