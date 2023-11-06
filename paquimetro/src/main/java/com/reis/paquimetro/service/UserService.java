package com.reis.paquimetro.service;

import com.reis.paquimetro.model.DTO.UserDTO;
import com.reis.paquimetro.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity createUser(UserDTO userDTO);

    List<User> getAllUsers();

    User findById(Long id);

    ResponseEntity deleteUser(Long id);

    ResponseEntity editUser(Long id, UserDTO userDTO);

}
