package com.reis.paquimetro.model.DTO;

import com.reis.paquimetro.model.PaymentType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PaymentInformationDTO {

    @Valid
    @NonNull
    private PaymentType paymentType;

    private String cardNumber;

    private String securityNumber;

    private Date validationDate;

    private String cardOwnerName;

    @NotNull(message = "Id do usuário é um campo obrigatório e não pode estar em branco")
    private Long userId;

}
