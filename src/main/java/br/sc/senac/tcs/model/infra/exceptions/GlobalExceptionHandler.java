package br.sc.senac.tcs.model.infra.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.sc.senac.tcs.exception.CampoInvalidoException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CampoInvalidoException.class)
    public ResponseEntity<String> handleCampoInvalidoException(CampoInvalidoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

