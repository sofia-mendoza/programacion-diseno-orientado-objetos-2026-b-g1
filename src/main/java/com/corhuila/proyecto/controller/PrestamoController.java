package com.corhuila.proyecto.controller;

import com.corhuila.proyecto.dto.PrestamoDTO;
import com.corhuila.proyecto.service.PrestamoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService service;

    public PrestamoController(PrestamoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PrestamoDTO> listar() {
        return service.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrestamoDTO registrar(@RequestBody PrestamoDTO dto) {
        return service.registrar(dto);
    }

    @PostMapping("/{id}/devolucion")
    public PrestamoDTO devolver(@PathVariable Long id) {
        return service.devolver(id);
    }
}
