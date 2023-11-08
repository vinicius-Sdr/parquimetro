package com.reis.paquimetro.repository;

import com.reis.paquimetro.model.ServiceOrder;
import com.reis.paquimetro.model.User;
import com.reis.paquimetro.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {

    List<ServiceOrder> findAllByUser(User user);

    ServiceOrder findByUserAndIsOpenTrue(User user);


}
