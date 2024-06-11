package com.prueba.api.validation.controller;

import com.prueba.api.validation.model.ValidationRequest;
import com.prueba.api.validation.model.ValidationResponse;
import com.prueba.api.validation.service.ValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ValidationController {

    private final ValidationService service;

    public ValidationController(ValidationService service) {
        this.service = service;
    }

    @PostMapping("/validar")
    public ResponseEntity<ValidationResponse> validar(@RequestBody ValidationRequest request){
        return ResponseEntity.accepted().body(service.validationResponse(request));
    }
}
