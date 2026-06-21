package com.project.erp.erp_system.service;

import com.project.erp.erp_system.entity.Address;
import com.project.erp.erp_system.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow();
    }

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public Address updateAddress(Long id, Address update) {
        Address address = addressRepository.findById(id).orElseThrow();
        address.setLocality(update.getLocality());
        address.setCity(update.getCity());
        address.setDistrict(update.getDistrict());
        address.setState(update.getState());
        address.setCountry(update.getCountry());
        address.setPincode(update.getPincode());

        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

}
