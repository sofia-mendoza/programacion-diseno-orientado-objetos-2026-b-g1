package com.corhuila.proyecto.dto;

import java.util.List;

public record KitDTO(
        Long id,
        String codigo,
        String nombre,
        List<ComponenteDTO> componentes
) {
}
