package com.prueba.api.validation.exception;


import com.prueba.api.validation.model.ValidationResponse;

public class BusinessException extends RuntimeException {
    private ValidationResponse errorResponse;

    public BusinessException(ValidationResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public ValidationResponse getErrorResponse() {
        return errorResponse;
    }
}