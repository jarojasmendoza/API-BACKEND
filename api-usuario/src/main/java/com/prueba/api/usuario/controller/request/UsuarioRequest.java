package com.prueba.api.usuario.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {
    private String id;
    private String nombre;
    private String apellido;
    private int estado;
    private int edad;
}
