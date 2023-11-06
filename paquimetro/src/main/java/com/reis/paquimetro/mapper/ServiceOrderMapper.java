package com.reis.paquimetro.mapper;

import com.reis.paquimetro.model.DTO.ServiceOrderDTO;
import com.reis.paquimetro.model.ServiceOrder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ServiceOrderMapper {

    ServiceOrder dtoToEntity(ServiceOrderDTO serviceOrderDTO);

}
