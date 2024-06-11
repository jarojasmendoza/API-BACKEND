package com.prueba.api.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.api.validation.exception.BusinessException;
import com.prueba.api.validation.model.ValidationRequest;
import com.prueba.api.validation.model.ValidationResponse;
import com.prueba.api.validation.service.ValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ApiValidationApplicationTests {

	@InjectMocks
	private ValidationService service;
	private ObjectMapper objectMapper = new ObjectMapper();
	private ValidationRequest validation;
	private ValidationRequest validationError;


	@BeforeEach
	void setUp() throws IOException {
		MockitoAnnotations.openMocks(this);
		validation = objectMapper.readValue(new File("src/test/resources/usuarioNuevo.json"), ValidationRequest.class);
		validationError = objectMapper.readValue(new File("src/test/resources/usuarioError.json"), ValidationRequest.class);
	}

	@Test
	void testGuardarAlumno_ErrorValidacion() {

		BusinessException exception = assertThrows(BusinessException.class, () -> {
			ValidationResponse result = service.validationResponse(validationError);
		});
		assertNotNull(exception);
	}

	@Test
	void testGuardarAlumno_NewId() {

		ValidationResponse result = service.validationResponse(validation);

		assertTrue(result.getSuccessful());
		assertEquals(HttpStatus.ACCEPTED.value(), result.getStatusCode());
	}

}
