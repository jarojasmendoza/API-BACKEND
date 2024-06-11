package com.prueba.api.usuario.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.api.usuario.client.request.ValidationRequest;
import com.prueba.api.usuario.client.response.Error;
import com.prueba.api.usuario.client.response.ValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

@Service
public class ValidationCliente {
    @Autowired
    private RestTemplate restTemplate;
    private static final String VALIDATION_API_URL = "http://localhost:8081/api/v1/validar";

    public ValidationResponse validate(ValidationRequest request) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ValidationRequest> entity = new HttpEntity<>(request, headers);

        try {
            ResponseEntity<ValidationResponse> response = restTemplate.exchange(
                    VALIDATION_API_URL,
                    HttpMethod.POST,
                    entity,
                    ValidationResponse.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            return e.getResponseBodyAs(ValidationResponse.class);
        }
    }

}
