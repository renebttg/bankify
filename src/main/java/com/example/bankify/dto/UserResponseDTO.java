package com.example.bankify.dto;

import com.example.bankify.enums.UserRole;

import java.util.Set;

public record UserResponseDTO(

        Long id,
        String username,
        String email,
        boolean status,
        Set<UserRole> roles

) { }
