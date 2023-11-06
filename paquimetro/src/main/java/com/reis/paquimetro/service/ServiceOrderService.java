package com.reis.paquimetro.service;


import com.reis.paquimetro.model.DTO.ServiceOrderDTO;
import com.reis.paquimetro.model.ServiceOrder;
import org.springframework.http.ResponseEntity;

public interface ServiceOrderService {


    ResponseEntity createServiceOrder(ServiceOrderDTO vehicleDTO);

    ResponseEntity getAllServiceOrderByUser(Long userId);

    ServiceOrder findServiceOrderById(Long id);

    ResponseEntity deleteServiceOrder(Long id);

    ResponseEntity editServiceOrder(Long id, ServiceOrderDTO vehicleDTO);
}
