package com.reis.paquimetro.controller;

import com.reis.paquimetro.model.DTO.PaymentInformationDTO;
import com.reis.paquimetro.service.PaymentInformationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paymentInformation")
public class PaymentInformationController {

    @Autowired
    private PaymentInformationService paymentInformationService;

    @PostMapping
    public ResponseEntity savePaymentInformation(@Valid @RequestBody PaymentInformationDTO paymentInformationDTO) {
        return paymentInformationService.createPaymentInformation(paymentInformationDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPaymentInformationByUserId(@PathVariable(name = "id") @NotBlank Long id) {
        return ResponseEntity.ok().body(paymentInformationService.findPaymentInformationByUserId(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity editPaymentInformation(@PathVariable(name = "id") @NotBlank Long id, @Valid @RequestBody PaymentInformationDTO paymentInformationDTO) {

        return paymentInformationService.editPaymentInformation(id, paymentInformationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePaymentInformation(@PathVariable Long id) {

        return paymentInformationService.deletePaymentInformation(id);
    }


}
