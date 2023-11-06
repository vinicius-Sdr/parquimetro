package com.reis.paquimetro.service;

import com.reis.paquimetro.model.DTO.VehicleDTO;
import com.reis.paquimetro.model.Vehicle;
import org.springframework.http.ResponseEntity;


public interface VehicleService {

    ResponseEntity createVehicle(VehicleDTO vehicleDTO);

    ResponseEntity getAllVehicleByUser(Long userId);

    Vehicle findVehicleById(Long id);

    ResponseEntity deleteVehicle(Long id);

    ResponseEntity editVehicle(Long id, VehicleDTO vehicleDTO);

}
