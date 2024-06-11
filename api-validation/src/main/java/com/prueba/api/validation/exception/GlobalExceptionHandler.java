package com.prueba.api.validation.exception;

import com.prueba.api.validation.model.ValidationResponse;
import com.prueba.api.validation.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ValidationResponse> handleBusinessExceptions(BusinessException ex) {
        ValidationResponse errorResponse = ex.getErrorResponse();
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ValidationResponse> handleGenericExceptions(Exception ex) {
        Error error = new Error(null, ex.getMessage());
        ValidationResponse errorResponse = new ValidationResponse();
        errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setSuccessful(false);
        errorResponse.setErrors(Collections.singletonList(error));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}