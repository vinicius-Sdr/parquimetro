package com.reis.paquimetro.repository;

import com.reis.paquimetro.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    void deleteById(Integer id);

    public List<Address> findByStreetAndNeighborhoodAndCityAndState(String street, String neighborhood, String city, String state);


}
