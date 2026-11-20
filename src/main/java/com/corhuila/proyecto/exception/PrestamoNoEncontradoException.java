package com.corhuila.proyecto.exception;

public class PrestamoNoEncontradoException extends RuntimeException {

    public PrestamoNoEncontradoException(Long id) {
        super("No existe un préstamo con el número: " + id);
    }
}
