package com.reis.paquimetro.service.impl;

import com.reis.paquimetro.mapper.VehicleMapper;
import com.reis.paquimetro.model.DTO.VehicleDTO;
import com.reis.paquimetro.model.User;
import com.reis.paquimetro.model.Vehicle;
import com.reis.paquimetro.repository.VehicleRepository;
import com.reis.paquimetro.service.UserService;
import com.reis.paquimetro.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleMapper mapper;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity createVehicle(VehicleDTO vehicleDTO) {

        User user = userService.findById(vehicleDTO.getUserId());

        Vehicle vehicle = mapper.dtoToEntity(vehicleDTO);
        vehicle.setUser(user);


        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleRepository.save(vehicle));
    }

    @Override
    public ResponseEntity getAllVehicleByUser(Long userId) {
        User user = userService.findById(userId);
        return ResponseEntity.ok().body(vehicleRepository.findAllByUser(user));
    }

    @Override
    public Vehicle findVehicleById(Long id) {
        return vehicleRepository.findById(id).get();
    }

    @Override
    public ResponseEntity deleteVehicle(Long id) {
        if (vehicleRepository.findById(id).isPresent()) {
            vehicleRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("veiculo deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @Override
    public ResponseEntity editVehicle(Long id, VehicleDTO vehicleDTO) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        if (vehicleOptional.isPresent()) {
            Vehicle vehicle = mapper.dtoToEntity(vehicleDTO);
            vehicle.setId(id);
            return ResponseEntity.ok().body(vehicleRepository.save(vehicle));
        }else{
            return ResponseEntity.badRequest().body("Numero de id inválido");
        }
    }
}
