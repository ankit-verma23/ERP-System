package com.project.erp.erp_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String locality;

    @NotBlank(message = "Field can not be blank")
    private String city;
    @NotBlank(message = "Field can not be blank")
    private String district;
    @NotBlank(message = "Field can not be blank")
    private String state;
    @NotBlank(message = "Field can not be blank")
    private String country;
    @Pattern(
            regexp = "^[0-9]{6}$",
            message = "Pincode must contain exactly 6 digits"
    )
    private String pincode;

    @OneToOne(mappedBy = "address")
    private Student student;

}
