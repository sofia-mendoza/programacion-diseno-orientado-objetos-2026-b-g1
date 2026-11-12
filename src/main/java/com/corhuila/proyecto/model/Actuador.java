package com.corhuila.proyecto.model;

import jakarta.persistence.Entity;

@Entity
public class Actuador extends Componente {

    private double voltaje;

    protected Actuador() {
    }

    public Actuador(String codigo, String nombre, int cantidad, String ubicacion, double voltaje) {
        super(codigo, nombre, cantidad, ubicacion);
        setVoltaje(voltaje);
    }

    public double getVoltaje() { return voltaje; }

    public void setVoltaje(double voltaje) {
        if (voltaje <= 0) {
            throw new IllegalArgumentException("El voltaje debe ser mayor que 0");
        }
        this.voltaje = voltaje;
    }

    @Override
    public String describir() {
        return "Actuador " + getNombre() + " a " + voltaje + "V (x" + getCantidad() + ")";
    }
}
