package com.corhuila.proyecto.exception;

public class ComponenteNoEncontradoException extends RuntimeException {

    public ComponenteNoEncontradoException(String codigo) {
        super("No existe un componente con el código: " + codigo);
    }
}
