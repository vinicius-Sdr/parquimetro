package com.reis.paquimetro.model.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class ServiceOrderOpenDTO {

    @NotNull(message = "Obrigatório identificar se é tempo fixo ou não. O campo obrigatório e não pode estar em branco")
    private Boolean isFixedTime;

    @NotNull(message = "Horário de inicio é um campo obrigatório e não pode estar em branco")
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Double paidValue;

    @NotNull(message = "Id do usuário é um campo obrigatório e não pode estar em branco")
    private Long userId;

}
