package com.reis.paquimetro.model.DTO;

import jakarta.validation.constraints.NotNull;

public class PriceDTO {

    @NotNull(message = "Valor base é um campo obrigatório e não pode estar em branco")
    private Double price;


}
