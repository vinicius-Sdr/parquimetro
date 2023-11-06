package com.reis.paquimetro.service.impl;


import com.reis.paquimetro.mapper.UserMapper;
import com.reis.paquimetro.model.DTO.UserDTO;
import com.reis.paquimetro.model.User;
import com.reis.paquimetro.repository.UserRepository;
import com.reis.paquimetro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity createUser(UserDTO userDTO) {

    User user = mapper.userDTOtoEntity(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public ResponseEntity deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número de Id inválido");
    }

    @Override
    public ResponseEntity editUser(Long id, UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = mapper.userDTOtoEntity(userDTO);
            user.setId(id);
            return ResponseEntity.ok().body(userRepository.save(user));
        } else {
            return ResponseEntity.badRequest().body("Número de id inválido");
        }
    }


}
