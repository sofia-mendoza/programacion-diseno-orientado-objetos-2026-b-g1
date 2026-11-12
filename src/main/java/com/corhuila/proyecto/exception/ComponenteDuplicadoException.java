package com.corhuila.proyecto.exception;

public class ComponenteDuplicadoException extends RuntimeException {

    public ComponenteDuplicadoException(String codigo) {
        super("Ya existe un componente con el código: " + codigo);
    }
}
