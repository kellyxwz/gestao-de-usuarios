package com.cadastro.usuarios.application.mapper;

import com.cadastro.usuarios.application.contracts.reponse.UserReesponse;
import com.cadastro.usuarios.application.contracts.request.UserRequest;
import com.cadastro.usuarios.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserReesponse toDTO (User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", constant = "true")
    @Mapping(target = "role", source = "role")
    User toEntity (UserRequest usersRequest);

}
