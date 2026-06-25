package com.project.erp.erp_system.controller;

import com.project.erp.erp_system.dto.AddressRequest;
import com.project.erp.erp_system.dto.AddressResponse;
import com.project.erp.erp_system.entity.Address;
import com.project.erp.erp_system.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public AddressResponse createAddress(@Valid @RequestBody AddressRequest address) {
        return addressService.createAddress(address);
    }

    @GetMapping("/{id}")
    public AddressResponse getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @GetMapping
    public List<AddressResponse> getAllAddress() {
        return addressService.getAllAddress();
    }

    @PutMapping("/{id}")
    public AddressResponse updateAddress(@PathVariable Long id, @Valid @RequestBody AddressRequest address) {
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }

}
