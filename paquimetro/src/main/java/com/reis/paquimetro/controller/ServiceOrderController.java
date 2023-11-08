package com.reis.paquimetro.controller;

import com.reis.paquimetro.model.DTO.ServiceOrderCloseDTO;
import com.reis.paquimetro.model.DTO.ServiceOrderOpenDTO;
import com.reis.paquimetro.service.ServiceOrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/serviceOrder")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @PostMapping
    public ResponseEntity saveServiceOrder(@Valid @RequestBody ServiceOrderOpenDTO serviceOrderOpenDTO) {
        return serviceOrderService.createServiceOrder(serviceOrderOpenDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity getServiceOrderByUserId(@PathVariable(name = "id") @NotBlank Long id) {
        return ResponseEntity.ok().body(serviceOrderService.findServiceOrderById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity editServiceOrder(@PathVariable(name = "id") @NotBlank Long id, @Valid @RequestBody ServiceOrderCloseDTO serviceOrderCloseDTO) {

        return serviceOrderService.editServiceOrder(id, serviceOrderCloseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteServiceOrder(@PathVariable Long id) {

        return serviceOrderService.deleteServiceOrder(id);
    }


}
