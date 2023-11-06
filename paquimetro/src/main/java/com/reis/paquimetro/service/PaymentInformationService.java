package com.reis.paquimetro.service;

import com.reis.paquimetro.model.DTO.PaymentInformationDTO;
import com.reis.paquimetro.model.PaymentInformation;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface PaymentInformationService {

    ResponseEntity createPaymentInformation(PaymentInformationDTO vehicleDTO);

    ResponseEntity<List<PaymentInformation>> findPaymentInformationByUserId(Long id);

    ResponseEntity deletePaymentInformation(Long id);

    ResponseEntity editPaymentInformation(Long id, PaymentInformationDTO vehicleDTO);
    
}
