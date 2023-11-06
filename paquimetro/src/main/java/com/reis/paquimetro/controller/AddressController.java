package com.reis.paquimetro.controller;

import com.reis.paquimetro.model.DTO.AddressDTO;
import com.reis.paquimetro.service.AddressService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity saveAddress(@Valid @RequestBody AddressDTO addressDTO) {
        return addressService.createAddress(addressDTO);
    }

    @GetMapping
    public ResponseEntity getAddresses(@Valid @RequestParam(required = false) String street, @Valid @RequestParam(required = false) String neighborhood, @Valid @RequestParam(required = false) String city, @Valid @RequestParam(required = false) String state) {

        return ResponseEntity.ok().body(addressService.getAllAddress(street, neighborhood, city, state));
    }

    @GetMapping("/{id}")
    public ResponseEntity getAddressById(@PathVariable(name = "id") @NotBlank Long id) {
        return ResponseEntity.ok().body(addressService.findById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity editAddress(@PathVariable(name = "id") @NotBlank Long id, @Valid @RequestBody AddressDTO addressDTO) {

        return addressService.editAddress(id, addressDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAddress(@PathVariable Long id) {

        return addressService.deleteAddress(id);
    }


}
