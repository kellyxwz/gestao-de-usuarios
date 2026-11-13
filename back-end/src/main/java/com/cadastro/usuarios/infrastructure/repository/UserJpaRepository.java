package com.cadastro.usuarios.infrastructure.repository;

import com.cadastro.usuarios.domain.model.User;
import com.cadastro.usuarios.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByEmail(String email);

}
