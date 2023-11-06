package com.reis.paquimetro.repository;

import com.reis.paquimetro.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<Price, Long> {
}
