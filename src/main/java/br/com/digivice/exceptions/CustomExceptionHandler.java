package br.com.digivice.exceptions;

import br.com.digivice.exceptions.errors.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class CustomExceptionHandler{

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> handleEntityNotFoundException(EntityNotFoundException e, HttpServletRequest request){

        StandardError error = new StandardError();

        error.setTimestamp(Instant.now());
        error.setError(e.getMessage());
        error.setStatus(e.getStatusCode());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(error.getStatus()).body(error);
    }


}
