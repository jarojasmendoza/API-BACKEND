package com.prueba.api.validation.util;


public enum ErrorCode {

    ID_NULL("E001","El ID no puede ser nulo"),
    NOMBRE_BLANCO("E002","El nombre no puede estar vacío"),
    APELLIDO_BLANCO("E003","El apellido no puede estar vacío"),
    ESTADO_INVALIDO("E004","El estado no puede ser diferente de 0 o 1"),
    EDAD_INVALIDA("E005","La edad debe ser mayor que 0");

    ;
    private final String code;
    private final String message;

    ErrorCode(String code,String mensaje) {
        this.code = code;
        this.message = mensaje;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
