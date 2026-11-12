package com.corhuila.proyecto.controller;

import com.corhuila.proyecto.model.Kit;
import com.corhuila.proyecto.service.KitService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kits")
public class KitController {

    private final KitService service;

    public KitController(KitService service) {
        this.service = service;
    }

    @GetMapping
    public List<Kit> listar() {
        return service.listar();
    }

    @GetMapping("/{codigo}")
    public Kit buscar(@PathVariable String codigo) {
        return service.buscarPorCodigo(codigo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kit crear(@RequestBody Kit kit) {
        return service.crear(kit);
    }

    @PostMapping("/{codigoKit}/componentes/{codigoComponente}")
    public Kit agregarComponente(@PathVariable String codigoKit,
                                 @PathVariable String codigoComponente) {
        return service.agregarComponente(codigoKit, codigoComponente);
    }

    @DeleteMapping("/{codigoKit}/componentes/{codigoComponente}")
    public Kit quitarComponente(@PathVariable String codigoKit,
                                @PathVariable String codigoComponente) {
        return service.quitarComponente(codigoKit, codigoComponente);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable String codigo) {
        service.eliminar(codigo);
    }
}