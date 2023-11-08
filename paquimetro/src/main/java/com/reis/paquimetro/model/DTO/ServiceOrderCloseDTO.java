package com.reis.paquimetro.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class ServiceOrderCloseDTO {

    @NotNull
    private Boolean isOpen;

    @NotNull(message = "Id do usuário é um campo obrigatório e não pode estar em branco")
    private Long userId;

}
