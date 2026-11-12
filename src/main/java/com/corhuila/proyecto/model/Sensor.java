package com.corhuila.proyecto.model;

import jakarta.persistence.Entity;

@Entity
public class Sensor extends Componente {

    private String magnitud; // temperatura, distancia...

    protected Sensor() {
    }

    public Sensor(String codigo, String nombre, int cantidad, String ubicacion, String magnitud) {
        super(codigo, nombre, cantidad, ubicacion);
        setMagnitud(magnitud);
    }

    public String getMagnitud() { return magnitud; }

    public void setMagnitud(String magnitud) {
        if (magnitud == null || magnitud.isBlank()) {
            throw new IllegalArgumentException("La magnitud no puede estar vacía");
        }
        this.magnitud = magnitud;
    }

    @Override
    public String describir() {
        return "Sensor de " + magnitud + ": " + getNombre() + " (x" + getCantidad() + ")";
    }
}