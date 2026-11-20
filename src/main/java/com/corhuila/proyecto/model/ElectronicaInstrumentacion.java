package com.corhuila.proyecto.model;

import jakarta.persistence.Entity;

@Entity
public class ElectronicaInstrumentacion extends Componente {

    private String magnitud;

    protected ElectronicaInstrumentacion() {
    }

    public ElectronicaInstrumentacion(String nombre, int cantidad, String ubicacion, String magnitud) {
        super(Categoria.ELECTRONICA_INSTRUMENTACION, nombre, cantidad, ubicacion);
        setMagnitud(magnitud);
    }

    public String getMagnitud() { return magnitud; }

    public void setMagnitud(String magnitud) {
        if (magnitud == null || magnitud.isBlank()) {
            throw new IllegalArgumentException("La magnitud no puede estar vacía");
        }
        this.magnitud = magnitud.trim();
    }

    @Override
    public String getDetalle() {
        return magnitud;
    }

    @Override
    public void setDetalle(String detalle) {
        setMagnitud(detalle);
    }

    @Override
    public String describir() {
        return "Electrónica e instrumentación: " + getNombre() + " para " + magnitud + " (x" + getCantidad() + ")";
    }
}
