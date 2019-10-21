package com.switchfully.orm.sandbox.person;

import com.switchfully.orm.sandbox.ErrorResponse;
import com.switchfully.orm.sandbox.person.exceptions.PersonNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

import static java.lang.String.valueOf;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class PersonControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonControllerAdvice.class);

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse personNotFoundException(PersonNotFoundException exception) {
        ErrorResponse response = createResponse(exception.getMessage(), BAD_REQUEST);
        LOGGER.warn("(ID=" + response.getUniqueErrorCode() + ") Person for given ID was not found!", exception);
        return response;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse illegalArgumentException(IllegalArgumentException exception) {
        ErrorResponse response = createResponse(exception.getMessage(), BAD_REQUEST);
        LOGGER.warn("(ID=" + response.getUniqueErrorCode() + ") You provided an illegal argument!", exception);
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @Order(-1)
    public ErrorResponse someException(Exception exception) {
        ErrorResponse response = createResponse("Something unexpected went wrong. Please contact us by " +
                "providing the unique error code", INTERNAL_SERVER_ERROR);
        LOGGER.error("(ID=" + response.getUniqueErrorCode() + ") An unexpected exception occurred!", exception);
        return response;
    }

    private ErrorResponse createResponse(String message, HttpStatus status) {
        return new ErrorResponse()
                .setMessage(message)
                .setStatusCode(valueOf(status.value()))
                .setUniqueErrorCode(UUID.randomUUID().toString());
    }

}
