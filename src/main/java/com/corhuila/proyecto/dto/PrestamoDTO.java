package com.corhuila.proyecto.dto;

import java.time.LocalDateTime;

public record PrestamoDTO(
        Long id,
        String codigoComponente,
        String nombreComponente,
        String solicitante,
        Integer cantidad,
        LocalDateTime fechaHoraPrestamo,    // la pone el sistema
        LocalDateTime fechaHoraDevolucion,  // vacía hasta que se devuelve
        String estado                       // PRESTADO o DEVUELTO
) {
}
