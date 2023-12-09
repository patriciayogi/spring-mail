package com.pyogi.message.mail;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleApplicationException(MethodArgumentNotValidException ex) {
        String error = ex.getAllErrors().stream().findFirst().orElse(new ObjectError("mail", "missing field")).getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
