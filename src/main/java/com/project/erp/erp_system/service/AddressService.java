package com.project.erp.erp_system.service;

import com.project.erp.erp_system.dto.AddressRequest;
import com.project.erp.erp_system.dto.AddressResponse;
import com.project.erp.erp_system.entity.Address;
import com.project.erp.erp_system.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private Address mapToEntity(AddressRequest request) {
        Address address = new Address();
        address.setLocality(request.getLocality());
        address.setCity(request.getCity());
        address.setDistrict(request.getDistrict());
        address.setState(request.getState());
        address.setCountry(request.getCountry());
        address.setPincode(request.getPincode());

        return address;
    }

    private AddressResponse mapToResponse(Address address) {
        AddressResponse response = new AddressResponse();

        response.setId(address.getId());
        response.setCity(address.getCity());
        response.setLocality(address.getLocality());
        response.setDistrict(address.getDistrict());
        response.setState(address.getState());
        response.setCountry(address.getCountry());
        response.setPincode(address.getPincode());

        return response;
    }

    @Autowired
    private AddressRepository addressRepository;

    public AddressResponse createAddress(AddressRequest request) {
        Address address = mapToEntity(request);
        Address savedAddress = addressRepository.save(address);
        return mapToResponse(savedAddress);
    }

    public AddressResponse getAddressById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow();
        return mapToResponse(address);
    }

    public List<AddressResponse> getAllAddress() {
        return addressRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public AddressResponse updateAddress(Long id, AddressRequest update) {
        Address address = addressRepository.findById(id).orElseThrow();
        address.setLocality(update.getLocality());
        address.setCity(update.getCity());
        address.setDistrict(update.getDistrict());
        address.setState(update.getState());
        address.setCountry(update.getCountry());
        address.setPincode(update.getPincode());

        Address savedAddress = addressRepository.save(address);
        return mapToResponse(savedAddress);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

}
