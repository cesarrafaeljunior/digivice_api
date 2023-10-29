package br.com.digivice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;

public class EntityNotFoundException extends HttpClientErrorException{

    private final String message;
    private final HttpStatusCode statusCode;
    public EntityNotFoundException(HttpStatusCode statusCode, String message){
        super(HttpStatus.BAD_REQUEST);
        this.statusCode = statusCode;
        this.message = message;

    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatusCode getStatusCode() {
        return statusCode;
    }
}
