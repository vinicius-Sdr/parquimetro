package com.reis.paquimetro.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ServiceOrderDTO {

    @NotBlank(message = "Obrigatório identificar se é tempo fixo ou não. O campo obrigatório e não pode estar em branco")
    private Boolean isFixedTime;

    @NotBlank(message = "Horário de inicio é um campo obrigatório e não pode estar em branco")
    private Date startTime;

    private Date endTime;

    private Double paidValue;

    @NotNull(message = "Id do usuário é um campo obrigatório e não pode estar em branco")
    private Long userId;

}
