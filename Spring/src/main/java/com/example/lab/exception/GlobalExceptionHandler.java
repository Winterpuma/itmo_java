package com.example.lab.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<String> handle(Exception ex) {
        log.error(ex.toString());
        return createResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(EntityNotFoundException ex) {
        log.error(ex.toString());
        return createResponseEntity(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(NonMatchingIdException ex) {
        log.error(ex.toString());
        return createResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> createResponseEntity(Exception ex, HttpStatus status) {
        return ResponseEntity.status(status).body(ex.getMessage());
    }
}
