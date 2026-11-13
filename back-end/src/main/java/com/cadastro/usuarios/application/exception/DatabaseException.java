package com.cadastro.usuarios.application.exception;

public class DatabaseException  extends RuntimeException {

    public DatabaseException(String msg) {
        super(msg);
    }
}
