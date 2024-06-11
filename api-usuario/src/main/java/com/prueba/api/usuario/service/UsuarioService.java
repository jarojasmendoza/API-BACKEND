package com.prueba.api.usuario.service;

import com.prueba.api.usuario.model.Usuario;
import com.prueba.api.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private  final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void guardarUsuario(Usuario usuario){
        repository.save(usuario);
    }
}
