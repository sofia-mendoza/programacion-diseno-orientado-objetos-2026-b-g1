package com.corhuila.proyecto.controller;

import com.corhuila.proyecto.service.RespaldoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/respaldo")
public class RespaldoController {

    private final RespaldoService service;

    public RespaldoController(RespaldoService service) {
        this.service = service;
    }

    @PostMapping("/exportar")
    public Map<String, Integer> exportar() {
        return Map.of("exportados", service.exportar());
    }

    @PostMapping("/importar")
    public Map<String, Integer> importar() {
        return service.importar();
    }
}
