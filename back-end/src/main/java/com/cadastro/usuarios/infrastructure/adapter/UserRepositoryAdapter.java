package com.cadastro.usuarios.infrastructure.adapter;

import com.cadastro.usuarios.domain.model.User;
import com.cadastro.usuarios.domain.port.UserRepository;
import com.cadastro.usuarios.infrastructure.entity.UserEntity;
import com.cadastro.usuarios.infrastructure.mapper.UserPersistenceMapper;
import com.cadastro.usuarios.infrastructure.repository.UserJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository jpaRepository;
    private final UserPersistenceMapper persistenceMapper;

    public UserRepositoryAdapter(
            UserJpaRepository jpaRepository,
            UserPersistenceMapper persistenceMapper) {
        this.jpaRepository = jpaRepository;
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(persistenceMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepository.findById(id)
                .map(persistenceMapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity entity = persistenceMapper.toEntity(user);
        UserEntity savedEntity = jpaRepository.save(entity);

        return persistenceMapper.toDomain(savedEntity);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}