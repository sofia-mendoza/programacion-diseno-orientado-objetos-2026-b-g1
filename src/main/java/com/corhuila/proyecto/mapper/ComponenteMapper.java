package com.corhuila.proyecto.mapper;

import com.corhuila.proyecto.dto.ComponenteDTO;
import com.corhuila.proyecto.model.AutomatizacionControl;
import com.corhuila.proyecto.model.Categoria;
import com.corhuila.proyecto.model.Componente;
import com.corhuila.proyecto.model.ElectronicaInstrumentacion;
import com.corhuila.proyecto.model.MecanicaPotencia;
import com.corhuila.proyecto.model.PrototipadoManufactura;
import com.corhuila.proyecto.model.Robotica;

public final class ComponenteMapper {

    private ComponenteMapper() {
    }

    // Entidad -> DTO (lo que se envía al navegador)
    public static ComponenteDTO aDto(Componente componente) {
        return new ComponenteDTO(
                componente.getId(),
                componente.getCategoria().name(),
                componente.getCodigo(),
                componente.getNombre(),
                componente.getCantidad(),
                componente.getUbicacion(),
                componente.getDetalle());
    }

    // DTO -> Entidad nueva (lo que llega del navegador); al crear el objeto se ejecutan las validaciones
    public static Componente aEntidad(ComponenteDTO dto) {
        if (dto.categoria() == null) {
            throw new IllegalArgumentException("La categoría es obligatoria");
        }
        if (dto.cantidad() == null) {
            throw new IllegalArgumentException("La cantidad es obligatoria");
        }

        Categoria categoria;
        try {
            categoria = Categoria.valueOf(dto.categoria());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Categoría desconocida: " + dto.categoria());
        }

        return switch (categoria) {
            case MECANICA_POTENCIA -> new MecanicaPotencia(dto.nombre(), dto.cantidad(), dto.ubicacion(), dto.detalle());
            case ELECTRONICA_INSTRUMENTACION -> new ElectronicaInstrumentacion(dto.nombre(), dto.cantidad(), dto.ubicacion(), dto.detalle());
            case AUTOMATIZACION_CONTROL -> new AutomatizacionControl(dto.nombre(), dto.cantidad(), dto.ubicacion(), dto.detalle());
            case ROBOTICA -> new Robotica(dto.nombre(), dto.cantidad(), dto.ubicacion(), dto.detalle());
            case PROTOTIPADO_MANUFACTURA -> new PrototipadoManufactura(dto.nombre(), dto.cantidad(), dto.ubicacion(), dto.detalle());
        };
    }
}
