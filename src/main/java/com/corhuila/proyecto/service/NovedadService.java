package com.corhuila.proyecto.service;

import com.corhuila.proyecto.dto.NovedadDTO;
import com.corhuila.proyecto.exception.StockInsuficienteException;
import com.corhuila.proyecto.mapper.NovedadMapper;
import com.corhuila.proyecto.model.Componente;
import com.corhuila.proyecto.model.Novedad;
import com.corhuila.proyecto.model.TipoNovedad;
import com.corhuila.proyecto.repository.ComponenteRepository;
import com.corhuila.proyecto.repository.NovedadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NovedadService {

    private final NovedadRepository novedadRepository;
    private final ComponenteRepository componenteRepository;
    private final ComponenteService componenteService;

    public NovedadService(NovedadRepository novedadRepository,
                          ComponenteRepository componenteRepository,
                          ComponenteService componenteService) {
        this.novedadRepository = novedadRepository;
        this.componenteRepository = componenteRepository;
        this.componenteService = componenteService;
    }

    public List<NovedadDTO> listar() {
        return novedadRepository.findAllByOrderByFechaHoraDesc().stream()
                .map(NovedadMapper::aDto)
                .toList();
    }

    // Un componente dañado, extraviado o fuera de servicio deja de estar disponible:
    // se descuentan esas unidades del inventario y queda el registro con fecha y hora.
    @Transactional
    public NovedadDTO registrar(NovedadDTO dto) {
        if (dto.codigoComponente() == null || dto.codigoComponente().isBlank()) {
            throw new IllegalArgumentException("El componente es obligatorio");
        }
        if (dto.tipo() == null) {
            throw new IllegalArgumentException("El tipo de novedad es obligatorio");
        }
        if (dto.cantidad() == null) {
            throw new IllegalArgumentException("La cantidad es obligatoria");
        }

        TipoNovedad tipo;
        try {
            tipo = TipoNovedad.valueOf(dto.tipo());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de novedad desconocido: " + dto.tipo());
        }

        Componente componente = componenteService.obtenerEntidad(dto.codigoComponente());
        Novedad novedad = new Novedad(componente, tipo, dto.cantidad(), dto.descripcion()); // valida los datos

        if (dto.cantidad() > componente.getCantidad()) {
            throw new StockInsuficienteException(componente.getNombre(), componente.getCantidad(), dto.cantidad());
        }
        componente.setCantidad(componente.getCantidad() - dto.cantidad());
        componenteRepository.save(componente);

        return NovedadMapper.aDto(novedadRepository.save(novedad));
    }
}
