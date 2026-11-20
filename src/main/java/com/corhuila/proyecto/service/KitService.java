package com.corhuila.proyecto.service;

import com.corhuila.proyecto.dto.KitDTO;
import com.corhuila.proyecto.exception.KitNoEncontradoException;
import com.corhuila.proyecto.mapper.KitMapper;
import com.corhuila.proyecto.model.Componente;
import com.corhuila.proyecto.model.Kit;
import com.corhuila.proyecto.repository.KitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KitService {

    private static final String PREFIJO_CODIGO = "KIT";

    private final KitRepository kitRepository;
    private final ComponenteService componenteService;

    public KitService(KitRepository kitRepository, ComponenteService componenteService) {
        this.kitRepository = kitRepository;
        this.componenteService = componenteService;
    }

    public List<KitDTO> listar() {
        return kitRepository.findAll().stream().map(KitMapper::aDto).toList();
    }

    public KitDTO buscarPorCodigo(String codigo) {
        return KitMapper.aDto(obtenerEntidad(codigo));
    }

    private Kit obtenerEntidad(String codigo) {
        return kitRepository.findByCodigo(codigo)
                .orElseThrow(() -> new KitNoEncontradoException(codigo));
    }

    public KitDTO crear(KitDTO dto) {
        Kit nuevo = KitMapper.aEntidad(dto);
        nuevo.asignarCodigo(generarCodigo());
        return KitMapper.aDto(kitRepository.save(nuevo));
    }

    // Código automático: KIT-001, KIT-002...
    private String generarCodigo() {
        int siguiente = kitRepository.findTopByOrderByIdDesc()
                .map(ultimo -> numeroDe(ultimo.getCodigo()) + 1)
                .orElse(1);
        return String.format("%s-%03d", PREFIJO_CODIGO, siguiente);
    }

    private int numeroDe(String codigo) {
        return Integer.parseInt(codigo.substring(codigo.indexOf('-') + 1));
    }

    @Transactional
    public KitDTO agregarComponente(String codigoKit, String codigoComponente) {
        Kit kit = obtenerEntidad(codigoKit);
        Componente componente = componenteService.obtenerEntidad(codigoComponente);
        kit.agregarComponente(componente);
        return KitMapper.aDto(kitRepository.save(kit));
    }

    @Transactional
    public KitDTO quitarComponente(String codigoKit, String codigoComponente) {
        Kit kit = obtenerEntidad(codigoKit);
        Componente componente = componenteService.obtenerEntidad(codigoComponente);
        kit.quitarComponente(componente);
        return KitMapper.aDto(kitRepository.save(kit));
    }

    public void eliminar(String codigo) {
        kitRepository.delete(obtenerEntidad(codigo));
    }
}
