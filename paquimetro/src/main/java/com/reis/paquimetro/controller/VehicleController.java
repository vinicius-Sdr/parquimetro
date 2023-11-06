package com.reis.paquimetro.controller;

import com.reis.paquimetro.model.DTO.VehicleDTO;
import com.reis.paquimetro.service.VehicleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity saveVehicle(@Valid @RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.createVehicle(vehicleDTO);
    }

    @GetMapping
    public ResponseEntity getVehiclees(@Valid @RequestParam(required = true) Long userId) {

        return ResponseEntity.ok().body(vehicleService.getAllVehicleByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity getVehicleById(@PathVariable(name = "id") @NotBlank Long id) {
        return ResponseEntity.ok().body(vehicleService.findVehicleById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity editVehicle(@PathVariable(name = "id") @NotBlank Long id, @Valid @RequestBody VehicleDTO vehicleDTO) {

        return vehicleService.editVehicle(id, vehicleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVehicle(@PathVariable Long id) {

        return vehicleService.deleteVehicle(id);
    }


}
