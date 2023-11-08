package com.reis.paquimetro.controller;

import com.reis.paquimetro.model.Price;
import com.reis.paquimetro.service.PricesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security/price")
public class PriceController {

    @Autowired
    private PricesService pricesService;

    @PostMapping
    public ResponseEntity updatePrice(@Valid @RequestParam(required = true) Double price){
        return pricesService.createPrices(price);
    }

    @GetMapping
    public Price getCurrentPrice(){
        return pricesService.findCurrentPrice();
    }



}
