package com.dimas.mtsdigitaltask.controller.advice;

import com.dimas.mtsdigitaltask.exception.MovieNotFoundException;
import com.dimas.mtsdigitaltask.model.dto.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ExceptionMessage> handleGeneratingTokenException(MovieNotFoundException exception) {
        return new ResponseEntity<>(new ExceptionMessage(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
