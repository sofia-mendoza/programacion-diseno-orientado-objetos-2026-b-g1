package com.corhuila.proyecto.dto;

public record ComponenteDTO(
        Long id,
        String categoria,   // MECANICA_POTENCIA, ELECTRONICA_INSTRUMENTACION, AUTOMATIZACION_CONTROL, ROBOTICA o PROTOTIPADO_MANUFACTURA
        String codigo,      // lo genera el sistema; al crear no se envía
        String nombre,
        Integer cantidad,
        String ubicacion,
        String detalle      // material, magnitud, voltaje, controlador o marca según la categoría
) {
}
