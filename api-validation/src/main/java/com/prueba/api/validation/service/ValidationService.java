package com.prueba.api.validation.service;

import com.prueba.api.validation.exception.BusinessException;
import com.prueba.api.validation.model.ValidationRequest;
import com.prueba.api.validation.model.ValidationResponse;
import com.prueba.api.validation.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.prueba.api.validation.util.ErrorCode.*;

@Service
public class ValidationService {

    public ValidationResponse validationResponse (ValidationRequest request){
        ValidationResponse response = new ValidationResponse();
        response.setStatusCode(HttpStatus.ACCEPTED.value());
        response.setSuccessful(true);

        List<Error> errores = new ArrayList<>();
        if (request.getId() == null) {
            errores.add(new Error(ID_NULL.getCode(), ID_NULL.getMessage()));
        }
        if (request.getNombre() == null || request.getNombre().trim().isEmpty()) {
            errores.add(new Error(NOMBRE_BLANCO.getCode(),NOMBRE_BLANCO.getMessage()));
        }
        if (request.getApellido() == null || request.getApellido().trim().isEmpty()) {
            errores.add(new Error(APELLIDO_BLANCO.getCode(), APELLIDO_BLANCO.getMessage()));
        }
        if (request.getEstado() > 1) {
            errores.add(new Error(ESTADO_INVALIDO.getCode(),ESTADO_INVALIDO.getMessage()));
        }
        if (request.getEdad() <= 0) {
            errores.add(new Error(EDAD_INVALIDA.getCode(), EDAD_INVALIDA.getMessage()));
        }

        if (!errores.isEmpty()) {
            response.setErrors(errores);
            response.setSuccessful(false);
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            throw new BusinessException(response);
        }

        return response;
    }
}
