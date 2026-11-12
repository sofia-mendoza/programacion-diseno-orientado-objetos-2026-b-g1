package com.corhuila.proyecto.service;

import com.corhuila.proyecto.exception.ComponenteDuplicadoException;
import com.corhuila.proyecto.model.Componente;
import com.corhuila.proyecto.repository.ComponenteCsvRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RespaldoService {

    private final ComponenteService componenteService;
    private final ComponenteCsvRepository csvRepository;

    public RespaldoService(ComponenteService componenteService, ComponenteCsvRepository csvRepository) {
        this.componenteService = componenteService;
        this.csvRepository = csvRepository;
    }

    public int exportar() {
        List<Componente> todos = componenteService.listar();
        csvRepository.guardar(todos);
        return todos.size();
    }

    public Map<String, Integer> importar() {
        int importados = 0;
        int omitidos = 0;
        for (Componente componente : csvRepository.cargar()) {
            try {
                componenteService.crear(componente);
                importados++;
            } catch (ComponenteDuplicadoException e) {
                omitidos++; // ya existía en la base de datos
            }
        }
        return Map.of("importados", importados, "omitidos", omitidos);
    }
}