package com.reis.paquimetro.service;

import com.reis.paquimetro.model.Address;
import com.reis.paquimetro.model.DTO.AddressDTO;
import org.springframework.http.ResponseEntity;

public interface AddressService {

    ResponseEntity createAddress(AddressDTO addressDTO);

    ResponseEntity getAllAddress();

    Address findById(Long id);

    ResponseEntity deleteAddress(Long id);

    ResponseEntity editAddress(Long id, AddressDTO addressDTO);

    ResponseEntity getAllAddress(String street, String neighborhood, String city, String state);
}
