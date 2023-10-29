package br.com.digivice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandler{

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> handleEntityNotFoundException(EntityNotFoundException e){

        StandardError error = new StandardError();

        error.setTimestamp(Instant.now());
        error.setError(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setPath("teste");

        return ResponseEntity.status(error.getStatus()).body(error);
    }


}
