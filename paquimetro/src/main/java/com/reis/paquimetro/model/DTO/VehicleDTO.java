package com.reis.paquimetro.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDTO {
    @NotBlank(message = "Placa é um campo obrigatório e não pode estar em branco")
    private String plate;

    @NotBlank(message = "Tipo do veiculo é um campo obrigatório e não pode estar em branco")
    private String vehicleType;

    @NotBlank(message = "Fabricante do veiculo é um campo obrigatório e não pode estar em branco")
    private String brand;

    @NotBlank(message = "Modelo do veículo é um campo obrigatório e não pode estar em branco")
    private String model;

    @NotNull(message = "Id do usuário é um campo obrigatório e não pode estar em branco")
    private Long userId;






}
