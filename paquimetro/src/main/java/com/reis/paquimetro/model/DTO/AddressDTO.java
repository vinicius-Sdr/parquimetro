package com.reis.paquimetro.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    @NotBlank(message = "Rua é um campo obrigatório e não pode estar em branco")
    private String street;

    @NotBlank(message = "Número é um campo obrigatório e não pode estar em branco")
    private String number;

    @NotBlank(message = "Bairro é um campo obrigatório e não pode estar em branco")
    private String neighborhood;

    @NotBlank(message = "Cidade é um campo obrigatório e não pode estar em branco")
    private String city;

    @NotBlank(message = "Estado é um campo obrigatório e não pode estar em branco")
    private String state;

    private String complement;

    @NotNull(message = "Id do usuário é um campo obrigatório e não pode estar em branco")
    private Long userId;

}
