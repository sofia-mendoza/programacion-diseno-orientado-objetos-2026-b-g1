package com.corhuila.proyecto.exception;

public class KitNoEncontradoException extends RuntimeException {

    public KitNoEncontradoException(String codigo) {
        super("No existe un kit con el código: " + codigo);
    }
}
