package com.reis.paquimetro.service.impl;

import com.reis.paquimetro.model.Price;
import com.reis.paquimetro.repository.PricesRepository;
import com.reis.paquimetro.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    private PricesRepository pricesRepository;

    @Override
    public ResponseEntity createPrices(Double currentBasePrice) {
        return null;
    }

    @Override
    public Price findCurrentPrice() {
        Price price = pricesRepository.findByIsCurrentValue(true);
        return price;
    }
}
