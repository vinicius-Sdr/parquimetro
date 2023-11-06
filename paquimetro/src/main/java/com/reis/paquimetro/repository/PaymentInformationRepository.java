package com.reis.paquimetro.repository;

import com.reis.paquimetro.model.PaymentInformation;
import com.reis.paquimetro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentInformationRepository extends JpaRepository<PaymentInformation, Long> {


    List<PaymentInformation> findAllByUser(User user);
}
