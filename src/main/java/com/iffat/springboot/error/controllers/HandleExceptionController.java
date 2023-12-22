package com.iffat.springboot.error.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleExceptionController {

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<String> divideByZero(Exception exception) {

        return ResponseEntity.internalServerError().body("500 ERROR");
    }
}
