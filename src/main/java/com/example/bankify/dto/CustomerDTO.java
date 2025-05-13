package com.example.bankify.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public record CustomerDTO(
        @NotBlank(message = "O nome é obrigatório.")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
        String name,

        @NotBlank(message = "O e-mail é obrigatório.")
        @Email(message = "E-mail deve ser válido.")
        @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres.")
        String email,

        @NotBlank(message = "O CPF é obrigatório.")
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos.")
        String cpf,

        @NotBlank(message = "A senha é obrigatória.")
        @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
        String password,

        @Size(max = 15, message = "O telefone deve ter no máximo 15 caracteres.")
        String phone,

        @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres.")
        String address,

        @NotNull(message = "O status é obrigatório.")
        Boolean status,

        List<AccountDTO> accounts
) {}
