package com.cadastro.usuarios.domain.port;

import com.cadastro.usuarios.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    boolean existsByEmail(String email);

    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);

    boolean existsById(Long id);
}