package com.corhuila.proyecto.service;

import com.corhuila.proyecto.dto.PrestamoDTO;
import com.corhuila.proyecto.exception.PrestamoNoEncontradoException;
import com.corhuila.proyecto.exception.StockInsuficienteException;
import com.corhuila.proyecto.mapper.PrestamoMapper;
import com.corhuila.proyecto.model.Componente;
import com.corhuila.proyecto.model.Prestamo;
import com.corhuila.proyecto.repository.ComponenteRepository;
import com.corhuila.proyecto.repository.PrestamoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final ComponenteRepository componenteRepository;
    private final ComponenteService componenteService;

    public PrestamoService(PrestamoRepository prestamoRepository,
                           ComponenteRepository componenteRepository,
                           ComponenteService componenteService) {
        this.prestamoRepository = prestamoRepository;
        this.componenteRepository = componenteRepository;
        this.componenteService = componenteService;
    }

    public List<PrestamoDTO> listar() {
        return prestamoRepository.findAllByOrderByFechaHoraPrestamoDesc().stream()
                .map(PrestamoMapper::aDto)
                .toList();
    }

    // Registrar un préstamo descuenta las unidades del inventario. Todo en una transacción:
    // o se guarda el préstamo y se descuenta el stock, o no se hace nada.
    @Transactional
    public PrestamoDTO registrar(PrestamoDTO dto) {
        if (dto.codigoComponente() == null || dto.codigoComponente().isBlank()) {
            throw new IllegalArgumentException("El componente es obligatorio");
        }
        if (dto.cantidad() == null) {
            throw new IllegalArgumentException("La cantidad es obligatoria");
        }

        Componente componente = componenteService.obtenerEntidad(dto.codigoComponente());
        Prestamo prestamo = new Prestamo(componente, dto.solicitante(), dto.cantidad()); // valida los datos

        if (dto.cantidad() > componente.getCantidad()) {
            throw new StockInsuficienteException(componente.getNombre(), componente.getCantidad(), dto.cantidad());
        }
        componente.setCantidad(componente.getCantidad() - dto.cantidad());
        componenteRepository.save(componente);

        return PrestamoMapper.aDto(prestamoRepository.save(prestamo));
    }

    // Registrar la devolución repone las unidades al inventario
    @Transactional
    public PrestamoDTO devolver(Long id) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new PrestamoNoEncontradoException(id));
        prestamo.registrarDevolucion();

        Componente componente = prestamo.getComponente();
        componente.setCantidad(componente.getCantidad() + prestamo.getCantidad());
        componenteRepository.save(componente);

        return PrestamoMapper.aDto(prestamoRepository.save(prestamo));
    }
}
