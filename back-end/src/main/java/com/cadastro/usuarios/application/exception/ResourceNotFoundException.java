package com.cadastro.usuarios.application.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id) {
        super("Recurso não encontrado com o id: " + id);
    }
}
