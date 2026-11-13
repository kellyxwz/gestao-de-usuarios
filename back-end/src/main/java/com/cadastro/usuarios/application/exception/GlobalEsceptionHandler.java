package com.cadastro.usuarios.application.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalEsceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandarError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){

        String erroMessage = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandarError err = new StandarError(
                Instant.now(),
                status.value(),
                erroMessage,
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<StandarError> emailAlreadyExists(
            EmailAlreadyExistsException e,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.CONFLICT;

        StandarError err = new StandarError(
                Instant.now(),
                status.value(),
                "Conflito",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandarError> database (DatabaseException e, HttpServletRequest request){
        String erro = "Erro de banco de dados";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandarError err = new StandarError(
                Instant.now(),
                status.value(),
                erro,
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(err);
    }



}
