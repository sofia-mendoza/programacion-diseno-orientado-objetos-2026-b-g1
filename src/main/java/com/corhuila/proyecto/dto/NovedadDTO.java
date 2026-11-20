package com.corhuila.proyecto.dto;

import java.time.LocalDateTime;

public record NovedadDTO(
        Long id,
        String codigoComponente,
        String nombreComponente,
        String tipo,            // DANADO, EXTRAVIADO o FUERA_DE_SERVICIO
        Integer cantidad,
        String descripcion,
        LocalDateTime fechaHora // la pone el sistema
) {
}
