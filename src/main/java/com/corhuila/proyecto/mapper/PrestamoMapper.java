package com.corhuila.proyecto.mapper;

import com.corhuila.proyecto.dto.PrestamoDTO;
import com.corhuila.proyecto.model.Prestamo;

public final class PrestamoMapper {

    private PrestamoMapper() {
    }

    public static PrestamoDTO aDto(Prestamo prestamo) {
        return new PrestamoDTO(
                prestamo.getId(),
                prestamo.getComponente().getCodigo(),
                prestamo.getComponente().getNombre(),
                prestamo.getSolicitante(),
                prestamo.getCantidad(),
                prestamo.getFechaHoraPrestamo(),
                prestamo.getFechaHoraDevolucion(),
                prestamo.getEstado().name());
    }
}
