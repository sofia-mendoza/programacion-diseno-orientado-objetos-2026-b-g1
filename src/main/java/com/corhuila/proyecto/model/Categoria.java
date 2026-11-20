package com.corhuila.proyecto.model;

public enum Categoria {

    MECANICA_POTENCIA("Mecánica y sistemas de potencia", "MEC", "Material"),
    ELECTRONICA_INSTRUMENTACION("Electrónica e instrumentación", "ELE", "Magnitud que mide o maneja"),
    AUTOMATIZACION_CONTROL("Automatización y control", "AUT", "Voltaje de operación (V)"),
    ROBOTICA("Robótica", "ROB", "Controlador compatible"),
    PROTOTIPADO_MANUFACTURA("Prototipado, manufactura y software", "PRO", "Marca o proveedor");

    private final String nombre;
    private final String prefijo;          // se usa para generar el código automático
    private final String etiquetaDetalle;  // cómo se llama el dato propio de la categoría

    Categoria(String nombre, String prefijo, String etiquetaDetalle) {
        this.nombre = nombre;
        this.prefijo = prefijo;
        this.etiquetaDetalle = etiquetaDetalle;
    }

    public String getNombre() { return nombre; }
    public String getPrefijo() { return prefijo; }
    public String getEtiquetaDetalle() { return etiquetaDetalle; }
}
