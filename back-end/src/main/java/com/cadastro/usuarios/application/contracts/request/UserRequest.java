package com.cadastro.usuarios.application.contracts.request;


import com.cadastro.usuarios.domain.enums.Role;

public record UserRequest(
        String name,
        String email,
        Role role
) {
}
