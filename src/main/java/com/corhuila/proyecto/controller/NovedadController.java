package com.corhuila.proyecto.controller;

import com.corhuila.proyecto.dto.NovedadDTO;
import com.corhuila.proyecto.service.NovedadService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/novedades")
public class NovedadController {

    private final NovedadService service;

    public NovedadController(NovedadService service) {
        this.service = service;
    }

    @GetMapping
    public List<NovedadDTO> listar() {
        return service.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NovedadDTO registrar(@RequestBody NovedadDTO dto) {
        return service.registrar(dto);
    }
}
