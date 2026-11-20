package com.corhuila.proyecto.model;

import jakarta.persistence.Entity;

@Entity
public class PrototipadoManufactura extends Componente {

    private String marca;

    protected PrototipadoManufactura() {
    }

    public PrototipadoManufactura(String nombre, int cantidad, String ubicacion, String marca) {
        super(Categoria.PROTOTIPADO_MANUFACTURA, nombre, cantidad, ubicacion);
        setMarca(marca);
    }

    public String getMarca() { return marca; }

    public void setMarca(String marca) {
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("La marca o el proveedor no puede estar vacío");
        }
        this.marca = marca.trim();
    }

    @Override
    public String getDetalle() {
        return marca;
    }

    @Override
    public void setDetalle(String detalle) {
        setMarca(detalle);
    }

    @Override
    public String describir() {
        return "Prototipado y manufactura: " + getNombre() + " de " + marca + " (x" + getCantidad() + ")";
    }
}
