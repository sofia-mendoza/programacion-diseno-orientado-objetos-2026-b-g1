package com.corhuila.proyecto.service;

import com.corhuila.proyecto.exception.KitNoEncontradoException;
import com.corhuila.proyecto.model.Componente;
import com.corhuila.proyecto.model.Kit;
import com.corhuila.proyecto.repository.KitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KitService {

    private final KitRepository kitRepository;
    private final ComponenteService componenteService;

    public KitService(KitRepository kitRepository, ComponenteService componenteService) {
        this.kitRepository = kitRepository;
        this.componenteService = componenteService;
    }

    public List<Kit> listar() {
        return kitRepository.findAll();
    }

    public Kit buscarPorCodigo(String codigo) {
        return kitRepository.findByCodigo(codigo)
                .orElseThrow(() -> new KitNoEncontradoException(codigo));
    }

    public Kit crear(Kit nuevo) {
        if (kitRepository.existsByCodigo(nuevo.getCodigo())) {
            throw new IllegalArgumentException("Ya existe un kit con el código: " + nuevo.getCodigo());
        }
        return kitRepository.save(nuevo);
    }

    @Transactional
    public Kit agregarComponente(String codigoKit, String codigoComponente) {
        Kit kit = buscarPorCodigo(codigoKit);
        Componente componente = componenteService.buscarPorCodigo(codigoComponente);
        kit.agregarComponente(componente);
        return kitRepository.save(kit);
    }

    @Transactional
    public Kit quitarComponente(String codigoKit, String codigoComponente) {
        Kit kit = buscarPorCodigo(codigoKit);
        Componente componente = componenteService.buscarPorCodigo(codigoComponente);
        kit.quitarComponente(componente);
        return kitRepository.save(kit);
    }

    public void eliminar(String codigo) {
        kitRepository.delete(buscarPorCodigo(codigo));
    }
}