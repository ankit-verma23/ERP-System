package com.project.erp.erp_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
    private String locality;
    private String city;
    private String district;
    private String state;
    private String country;
    private String pincode;
}
