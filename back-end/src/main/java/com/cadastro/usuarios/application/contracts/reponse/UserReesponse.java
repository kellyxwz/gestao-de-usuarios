package com.cadastro.usuarios.application.contracts.reponse;

import com.cadastro.usuarios.domain.enums.Role;

public record UserReesponse(
        String name,
        String email,
        Role role,
        Boolean activo
) {
}
