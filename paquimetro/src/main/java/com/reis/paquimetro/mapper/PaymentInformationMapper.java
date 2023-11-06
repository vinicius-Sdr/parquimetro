package com.reis.paquimetro.mapper;

import com.reis.paquimetro.model.DTO.PaymentInformationDTO;
import com.reis.paquimetro.model.PaymentInformation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PaymentInformationMapper {

    PaymentInformation dtoToEntity(PaymentInformationDTO paymentInformationDTO);

}
