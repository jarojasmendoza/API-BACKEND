package com.prueba.api.usuario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private int estado;
    private int edad;
}
