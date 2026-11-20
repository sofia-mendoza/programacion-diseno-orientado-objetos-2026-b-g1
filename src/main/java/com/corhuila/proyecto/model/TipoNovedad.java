package com.corhuila.proyecto.model;

public enum TipoNovedad {

    DANADO("Dañado"),
    EXTRAVIADO("Extraviado"),
    FUERA_DE_SERVICIO("Fuera de servicio");

    private final String nombre;

    TipoNovedad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
}
