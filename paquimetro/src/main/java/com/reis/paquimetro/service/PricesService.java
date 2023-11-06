package com.reis.paquimetro.service;

import com.reis.paquimetro.model.Price;
import org.springframework.http.ResponseEntity;

public interface PricesService {

    ResponseEntity createPrices(Double currentBasePrice);

    Price findCurrentPrice();

}
