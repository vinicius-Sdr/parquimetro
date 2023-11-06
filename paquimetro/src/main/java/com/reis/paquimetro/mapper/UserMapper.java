package com.reis.paquimetro.mapper;


import com.reis.paquimetro.model.DTO.UserDTO;
import com.reis.paquimetro.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

    User userDTOtoEntity(UserDTO userDTO);

}
