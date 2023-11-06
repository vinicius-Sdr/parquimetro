package com.reis.paquimetro.mapper;

import com.reis.paquimetro.model.Address;
import com.reis.paquimetro.model.DTO.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface AddressMapper {

    Address addressDTOtoEntity(AddressDTO addressDTO);


}
