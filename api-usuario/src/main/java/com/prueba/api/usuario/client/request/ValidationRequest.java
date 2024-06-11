package com.prueba.api.usuario.client.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationRequest {
    private String id;
    private String nombre;
    private String apellido;
    private int estado;
    private int edad;
}
