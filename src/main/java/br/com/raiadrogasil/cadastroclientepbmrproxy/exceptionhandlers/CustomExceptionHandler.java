package br.com.raiadrogasil.cadastroclientepbmrproxy.exceptionhandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

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

}
