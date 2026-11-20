package com.corhuila.proyecto.model;

import jakarta.persistence.Entity;

@Entity
public class MecanicaPotencia extends Componente {

    private String material;

    protected MecanicaPotencia() {
    }

    public MecanicaPotencia(String nombre, int cantidad, String ubicacion, String material) {
        super(Categoria.MECANICA_POTENCIA, nombre, cantidad, ubicacion);
        setMaterial(material);
    }

    public String getMaterial() { return material; }

    public void setMaterial(String material) {
        if (material == null || material.isBlank()) {
            throw new IllegalArgumentException("El material no puede estar vacío");
        }
        this.material = material.trim();
    }

    @Override
    public String getDetalle() {
        return material;
    }

    @Override
    public void setDetalle(String detalle) {
        setMaterial(detalle);
    }

    @Override
    public String describir() {
        return "Mecánica y potencia: " + getNombre() + " de " + material + " (x" + getCantidad() + ")";
    }
}
