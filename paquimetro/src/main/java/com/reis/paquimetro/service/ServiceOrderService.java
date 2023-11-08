package com.reis.paquimetro.service;


import com.reis.paquimetro.model.DTO.ServiceOrderCloseDTO;
import com.reis.paquimetro.model.DTO.ServiceOrderOpenDTO;
import com.reis.paquimetro.model.ServiceOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ServiceOrderService {


    ResponseEntity createServiceOrder(ServiceOrderOpenDTO vehicleDTO);

    ResponseEntity getAllServiceOrderByUser(Long userId);

    ServiceOrder findServiceOrderById(Long id);

    ResponseEntity deleteServiceOrder(Long id);

    ResponseEntity editServiceOrder(Long id, ServiceOrderCloseDTO serviceOrderCloseDTO);

    ServiceOrder findOpenServiceByUser(Long userId);
}
