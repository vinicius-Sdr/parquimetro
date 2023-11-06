package com.reis.paquimetro.mapper;

import com.reis.paquimetro.model.DTO.VehicleDTO;
import com.reis.paquimetro.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface VehicleMapper {

    Vehicle dtoToEntity(VehicleDTO vehicleDTO);

}
