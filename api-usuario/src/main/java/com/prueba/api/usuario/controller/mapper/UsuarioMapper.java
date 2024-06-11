package com.prueba.api.usuario.controller.mapper;

import com.prueba.api.usuario.client.request.ValidationRequest;
import com.prueba.api.usuario.controller.request.UsuarioRequest;
import com.prueba.api.usuario.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "apellido", source = "apellido")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "edad", source = "edad")
    Usuario fromUsuario(UsuarioRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "apellido", source = "apellido")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "edad", source = "edad")
    ValidationRequest fromValidation(UsuarioRequest request);
}
