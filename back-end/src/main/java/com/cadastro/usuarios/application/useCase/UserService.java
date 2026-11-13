package com.cadastro.usuarios.application.useCase;

import com.cadastro.usuarios.application.contracts.reponse.UserReesponse;
import com.cadastro.usuarios.application.contracts.request.UserRequest;
import com.cadastro.usuarios.application.exception.DatabaseException;
import com.cadastro.usuarios.application.exception.ResourceNotFoundException;
import com.cadastro.usuarios.application.mapper.UserMapper;
import com.cadastro.usuarios.domain.port.UserRepository;
import com.cadastro.usuarios.domain.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserReesponse> findAll() {
        return userRepository.findAll().stream().map(userMapper:: toDTO).toList();
    }

    public UserReesponse findById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        return userMapper.toDTO(user);
    }


    public void deleteById(Long id){
        if (!userRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }

        try {
            userRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw  new DatabaseException("Não foi possivel deletar usuário");
        }

    }

    public UserReesponse insert(UserRequest request){
        try {
            User user = userRepository.save(userMapper.toEntity(request));
            return userMapper.toDTO(user);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Não foi possivel salvar usuário");
        }
    }

    public UserReesponse update(UserRequest userRequest, Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        updateData(user, userRequest);

        try {
            User newUser = userRepository.save(user);

            return userMapper.toDTO(newUser);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Não foi possivel salvar usuário");
        }
    }

    public void updateData(User user, UserRequest request){
        user.setname(request.name());
        user.setEmail(request.email());
        user.setRole(request.role());
        user.setActivo(true);
    }

}
