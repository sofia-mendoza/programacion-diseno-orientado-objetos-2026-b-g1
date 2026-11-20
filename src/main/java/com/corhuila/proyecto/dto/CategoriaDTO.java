package com.corhuila.proyecto.dto;

public record CategoriaDTO(
        String id,              // MECANICA_POTENCIA, ROBOTICA...
        String nombre,          // nombre para mostrar
        String etiquetaDetalle  // nombre del dato propio de la categoría
) {
}
