package com.reis.paquimetro.service.impl;

import com.reis.paquimetro.mapper.AddressMapper;
import com.reis.paquimetro.model.Address;
import com.reis.paquimetro.model.DTO.AddressDTO;
import com.reis.paquimetro.model.User;
import com.reis.paquimetro.repository.AddressRepository;
import com.reis.paquimetro.service.AddressService;
import com.reis.paquimetro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper mapper;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserService userService;


    @Override
    public ResponseEntity createAddress(AddressDTO addressDTO) {

        User user = userService.findById(addressDTO.getUserId());

        Address address = mapper.addressDTOtoEntity(addressDTO);
        address.setUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(addressRepository.save(address));
    }

    @Override
    public ResponseEntity getAllAddress() {
        return ResponseEntity.ok().body(addressRepository.findAll());
    }

    @Override
    public Address findById(Long id) {

        return addressRepository.findById(id).get();
    }

    @Override
    public ResponseEntity deleteAddress(Long id) {
        if (addressRepository.findById(id).isPresent()) {
            addressRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @Override
    public ResponseEntity editAddress(Long id, AddressDTO addressDTO) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if (addressOptional.isPresent()) {
            Address address = mapper.addressDTOtoEntity(addressDTO);
            address.setId(id);
            return ResponseEntity.ok().body(addressRepository.save(address));
        }else{
        return ResponseEntity.badRequest().body("Numero de id inválido");
        }

    }

    @Override
    public ResponseEntity getAllAddress(String street, String neighborhood, String city, String state) {

        List<Address> addressList = addressRepository.findByStreetAndNeighborhoodAndCityAndState(street, neighborhood, city, state);

        if(!addressList.isEmpty()){
            return ResponseEntity.ok().body(addressList);
        }else{
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        }
    }
}
