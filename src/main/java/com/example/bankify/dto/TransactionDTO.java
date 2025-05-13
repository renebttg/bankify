package com.example.bankify.dto;

import com.example.bankify.enums.TransactionStatus;
import com.example.bankify.enums.TransactionType;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO(

        @NotNull(message = "O valor da transação é obrigatório.")
        @DecimalMin(value = "0.01", message = "O valor da transação deve ser positivo e maior que zero.")
        @Digits(integer = 17, fraction = 2, message = "O valor da transação deve ter até 17 dígitos inteiros e 2 decimais.")
        BigDecimal amount,

        @NotNull(message = "O tipo de transação é obrigatório.")
        TransactionType type,

        @NotNull(message = "A conta de origem é obrigatória.")
        Long sourceAccountId,

        Long destinationAccountId,

        @NotBlank(message = "A descrição não pode estar em branco.")
        @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
        String description,

        @NotNull(message = "O status da transação é obrigatório.")
        TransactionStatus status

) {}
