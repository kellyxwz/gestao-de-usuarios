package com.cadastro.usuarios.infrastructure.mapper;
import com.cadastro.usuarios.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import com.cadastro.usuarios.domain.model.User;


@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

    UserEntity toEntity(User user);

    User toDomain(UserEntity entity);
}