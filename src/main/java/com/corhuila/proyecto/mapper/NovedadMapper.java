package com.corhuila.proyecto.mapper;

import com.corhuila.proyecto.dto.NovedadDTO;
import com.corhuila.proyecto.model.Novedad;

public final class NovedadMapper {

    private NovedadMapper() {
    }

    public static NovedadDTO aDto(Novedad novedad) {
        return new NovedadDTO(
                novedad.getId(),
                novedad.getComponente().getCodigo(),
                novedad.getComponente().getNombre(),
                novedad.getTipo().name(),
                novedad.getCantidad(),
                novedad.getDescripcion(),
                novedad.getFechaHora());
    }
}
