package com.reis.paquimetro.controller;

import com.reis.paquimetro.service.PricesService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security/serviceOrder")
public class PriceController {

    private PricesService pricesService;

    public ResponseEntity updatePrice(@Valid @RequestParam(required = true) Double price){
        return pricesService.createPrices(price);
    }



}
