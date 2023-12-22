package com.iffat.springboot.error.controllers;

import com.iffat.springboot.error.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class HandleExceptionController {

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<Error> divideByZero(Exception exception) {

        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error division by zero");
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.internalServerError().body(error);
    }
}
