package com.corhuila.proyecto.model;

import jakarta.persistence.Entity;

@Entity
public class AutomatizacionControl extends Componente {

    private double voltaje; // voltaje de operación en voltios (V)

    protected AutomatizacionControl() {
    }

    public AutomatizacionControl(String nombre, int cantidad, String ubicacion, String voltaje) {
        super(Categoria.AUTOMATIZACION_CONTROL, nombre, cantidad, ubicacion);
        setVoltaje(aNumero(voltaje, "voltaje"));
    }

    public double getVoltaje() { return voltaje; }

    public void setVoltaje(double voltaje) {
        if (voltaje <= 0) {
            throw new IllegalArgumentException("El voltaje debe ser mayor que 0");
        }
        this.voltaje = voltaje;
    }

    @Override
    public String getDetalle() {
        return String.valueOf(voltaje);
    }

    @Override
    public void setDetalle(String detalle) {
        setVoltaje(aNumero(detalle, "voltaje"));
    }

    @Override
    public String describir() {
        return "Automatización y control: " + getNombre() + " a " + voltaje + "V (x" + getCantidad() + ")";
    }
}
