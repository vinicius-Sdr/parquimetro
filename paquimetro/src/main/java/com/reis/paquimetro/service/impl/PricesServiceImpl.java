package com.reis.paquimetro.service.impl;

import com.reis.paquimetro.model.Price;
import com.reis.paquimetro.repository.PricesRepository;
import com.reis.paquimetro.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    private PricesRepository pricesRepository;

    @Override
    public ResponseEntity createPrices(Double currentBasePrice) {
        Price currentPrice = findCurrentPrice();
        List<Price> priceList = new ArrayList<>();
        if(currentPrice == null){
            currentPrice = new Price();
            currentPrice.setPrice(currentBasePrice);
            currentPrice.setIsCurrentValue(true);
            priceList.add(currentPrice);
        }else{
            Price price = new Price();
            price.setPrice(currentBasePrice);
            price.setIsCurrentValue(true);
            priceList.add(price);

            currentPrice.setIsCurrentValue(false);
            priceList.add(currentPrice);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(pricesRepository.saveAll(priceList));
    }

    @Override
    public Price findCurrentPrice() {
        Price price = pricesRepository.findByIsCurrentValueTrue();
        return price;
    }
}
