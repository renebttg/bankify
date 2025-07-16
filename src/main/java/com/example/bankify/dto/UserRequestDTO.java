package com.example.bankify.dto;


import com.example.bankify.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record UserRequestDTO(
        @NotBlank(message = "Username é obrigatorio")
        @Size(min = 4, max = 50)
        String username,

        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 6, max = 100)
        String password,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotEmpty(message = "Pelo menos um papel deve ser informado")
        Set<UserRole> roles
) { }
