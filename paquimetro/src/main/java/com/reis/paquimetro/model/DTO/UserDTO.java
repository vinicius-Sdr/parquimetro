package com.reis.paquimetro.model.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "Nome é um campo obrigatório e não pode estar em branco")
    private String name;

    @NotBlank(message = "Aniversario é um campo obrigatório e não pode estar em branco")
    private String birthDate;

    @NotBlank(message = "Genero é um campo obrigatório e não pode estar em branco")
    private String gender;



}
