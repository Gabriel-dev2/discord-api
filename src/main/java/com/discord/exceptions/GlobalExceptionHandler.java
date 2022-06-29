package com.discord.exceptions;

import javax.security.auth.login.LoginException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.discord.model.ModelApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ModelApiResponse> handleLoginException() {
        ResponseEntity<ModelApiResponse> response = null;
        ModelApiResponse model = new ModelApiResponse();
        model.setCode(401);
        model.setMessage("Não foi possível autenticar-se ao discord");
        response = new ResponseEntity<>(model, HttpStatus.UNAUTHORIZED);
        return response;
    }

    @ExceptionHandler(InterruptedException.class)
    public ResponseEntity<ModelApiResponse> handleInterruptedException() {
        ResponseEntity<ModelApiResponse> response = null;
        ModelApiResponse model = new ModelApiResponse();
        model.setCode(502);
        model.setMessage("A Thread que estava execução interrompida");
        response = new ResponseEntity<>(model, HttpStatus.BAD_GATEWAY);
        return response;
    }
}
