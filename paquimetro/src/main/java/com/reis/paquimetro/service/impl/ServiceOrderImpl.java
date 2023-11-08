package com.reis.paquimetro.service.impl;

import com.reis.paquimetro.mapper.ServiceOrderMapper;
import com.reis.paquimetro.model.DTO.ServiceOrderCloseDTO;
import com.reis.paquimetro.model.DTO.ServiceOrderOpenDTO;
import com.reis.paquimetro.model.Price;
import com.reis.paquimetro.model.ServiceOrder;
import com.reis.paquimetro.model.User;
import com.reis.paquimetro.repository.ServiceOrderRepository;
import com.reis.paquimetro.service.PricesService;
import com.reis.paquimetro.service.ServiceOrderService;
import com.reis.paquimetro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class ServiceOrderImpl implements ServiceOrderService {


    @Autowired
    private UserService userService;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private PricesService pricesService;

    @Override
    public ResponseEntity createServiceOrder(ServiceOrderOpenDTO serviceOrderOpenDTO) {
        User user = userService.findById(serviceOrderOpenDTO.getUserId());
        if (user != null) {
            ServiceOrder serviceOrder = serviceOrderRepository.findByUserAndIsOpenTrue(user);
            if (serviceOrder == null) {
                Price price = pricesService.findCurrentPrice();
                    serviceOrder = new ServiceOrder();
                if (serviceOrderOpenDTO.getIsFixedTime() == true) {

                    serviceOrder.setUser(user);

                    Long timeToBePaid = ChronoUnit.HOURS.between(serviceOrderOpenDTO.getStartTime(), serviceOrderOpenDTO.getEndTime()) + 1;
                    serviceOrder.setPaidValue(timeToBePaid * price.getPrice());
                    serviceOrder.setStartTime(serviceOrderOpenDTO.getStartTime());
                    serviceOrder.setEndTime(serviceOrderOpenDTO.getEndTime());
                    serviceOrder.setIsFixedTime(true);
                    serviceOrder.setIsOpen(false);
                } else {
                    serviceOrder.setPrice(price);
                    serviceOrder.setUser(user);
                    serviceOrder.setPaidValue(pricesService.findCurrentPrice().getPrice());
                    serviceOrder.setStartTime(LocalDateTime.now());
                    serviceOrder.setIsFixedTime(false);
                    serviceOrder.setIsOpen(true);

                }

                return ResponseEntity.status(HttpStatus.CREATED).body(serviceOrderRepository.save(serviceOrder));
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("O usuário já tem um ticket aberto! Ele deve primeiro encerrar o ticket já existente");
            }
        }
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario não encontrado");
    }

    @Override
    public ResponseEntity getAllServiceOrderByUser(Long userId) {
        User user = userService.findById(userId);
        return ResponseEntity.ok().body(serviceOrderRepository.findAllByUser(user));
    }


    @Override
    public ResponseEntity deleteServiceOrder(Long id) {
        if (serviceOrderRepository.findById(id).isPresent()) {
            ServiceOrder serviceOrder = serviceOrderRepository.findById(id).get();
            if(serviceOrder.getIsOpen() != true) {
                serviceOrderRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body("");
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O ticket só pode ser deletado quando o pagamento for efetuado");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @Override
    public ResponseEntity editServiceOrder(Long userId, ServiceOrderCloseDTO serviceOrderCloseDTO) {
        ServiceOrder serviceOrder = findOpenServiceByUser(userId);
    if(serviceOrder != null) {
        if (serviceOrderCloseDTO.getIsOpen().equals(false)) {
            Price price = pricesService.findCurrentPrice();

            Long timeToBePaid = ChronoUnit.HOURS.between(serviceOrder.getStartTime(), LocalDateTime.now());
            serviceOrder.setPaidValue(timeToBePaid * price.getPrice());
            serviceOrder.setEndTime(LocalDateTime.now());
            serviceOrder.setIsOpen(false);

            return ResponseEntity.status(HttpStatus.OK).body(serviceOrderRepository.save(serviceOrder));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Um ticket já fechado não pode ser aberto. É necessária a criação de um novo ticket.");
    }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nenhum ticket em aberto foi encontrado");

    }

    @Override
    public ServiceOrder findOpenServiceByUser(Long userId) {
        User user = userService.findById(userId);
        return serviceOrderRepository.findByUserAndIsOpenTrue(user);
    }
}
