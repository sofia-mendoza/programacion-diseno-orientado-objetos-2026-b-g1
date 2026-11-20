package com.corhuila.proyecto.model;

import jakarta.persistence.Entity;

@Entity
public class Robotica extends Componente {

    private String controlador;

    protected Robotica() {
    }

    public Robotica(String nombre, int cantidad, String ubicacion, String controlador) {
        super(Categoria.ROBOTICA, nombre, cantidad, ubicacion);
        setControlador(controlador);
    }

    public String getControlador() { return controlador; }

    public void setControlador(String controlador) {
        if (controlador == null || controlador.isBlank()) {
            throw new IllegalArgumentException("El controlador compatible no puede estar vacío");
        }
        this.controlador = controlador.trim();
    }

    @Override
    public String getDetalle() {
        return controlador;
    }

    @Override
    public void setDetalle(String detalle) {
        setControlador(detalle);
    }

    @Override
    public String describir() {
        return "Robótica: " + getNombre() + " compatible con " + controlador + " (x" + getCantidad() + ")";
    }
}
