package br.com.raiadrogasil.cadastroclientepbmrproxy.exceptionhandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity handleConstraintViolation(ConstraintViolationException ex, WebRequest request){
        return ResponseEntity
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(ex.getConstraintViolations()
                        .stream()
                        .collect(Collectors.toMap(
                                violation -> violation.getPropertyPath().toString(),
                                violation -> violation.getMessage())));
    }

    @ExceptionHandler(HttpClientErrorException.class)
    protected ResponseEntity handleClientErrorException(HttpClientErrorException ex){
        return ResponseEntity.status(ex.getStatusCode())
                .headers(ex.getResponseHeaders())
                .body(ex.getResponseBodyAsString());
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity validationError(BindException ex) {

        return ResponseEntity
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(ex.getBindingResult()
                        .getAllErrors()
                        .stream()
                        .collect(Collectors.toMap(
                                msg -> msg.getCode(),
                                msg -> msg.getDefaultMessage()
                        )));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity validationError(Exception ex) {
        LOGGER.error("Ocorreu um erro no pbmr-proxy.", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }
}



