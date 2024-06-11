package com.prueba.api.usuario.controller;

import com.prueba.api.usuario.client.ValidationCliente;
import com.prueba.api.usuario.controller.mapper.UsuarioMapper;
import com.prueba.api.usuario.controller.request.UsuarioRequest;
import com.prueba.api.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    private final ValidationCliente validationClient;
    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @Autowired
    public UsuarioController(ValidationCliente validationClient, UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.validationClient = validationClient;
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody UsuarioRequest request){

        var responseValidation = validationClient.validate(usuarioMapper.fromValidation(request));
        usuarioService.guardarUsuario(usuarioMapper.fromUsuario(request));

        return  ResponseEntity
                .status(responseValidation.getStatusCode())
                .body(responseValidation);


    }
}
