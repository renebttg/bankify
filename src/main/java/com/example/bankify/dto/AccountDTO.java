package com.example.bankify.dto;

import com.example.bankify.enums.AccountType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record AccountDTO(
        @NotBlank(message = "O número da conta é obrigatório.")
        @Size(max = 20, message = "O número da conta deve ter no máximo 20 caracteres.")
        String accountNumber,

        @NotBlank(message = "A agência é obrigatória.")
        @Size(max = 10, message = "A agência deve ter no máximo 10 caracteres.")
        String agency,

        @NotNull(message = "O saldo é obrigatório.")
        @DecimalMin(value = "0.0", inclusive = true, message = "O saldo não pode ser negativo.")
        BigDecimal balance,

        @NotNull(message = "O tipo de conta é obrigatório.")
        AccountType accountType,

        @NotNull(message = "O ID do cliente é obrigatório.")
        Long customerId,

        @NotNull(message = "O status é obrigatório.")
        Boolean status
) {}
