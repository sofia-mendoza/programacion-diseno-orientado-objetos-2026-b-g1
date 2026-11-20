package com.corhuila.proyecto.exception;

public class StockInsuficienteException extends RuntimeException {

    public StockInsuficienteException(String nombre, int disponibles, int solicitadas) {
        super("No hay suficientes unidades de " + nombre
                + ": disponibles " + disponibles + ", solicitadas " + solicitadas);
    }
}
