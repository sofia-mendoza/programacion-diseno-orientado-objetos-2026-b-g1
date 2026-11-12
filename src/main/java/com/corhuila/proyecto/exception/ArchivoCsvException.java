package com.corhuila.proyecto.exception;

public class ArchivoCsvException extends RuntimeException {

    public ArchivoCsvException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
