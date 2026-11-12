package com.corhuila.proyecto.controller;

import com.corhuila.proyecto.model.Componente;
import com.corhuila.proyecto.service.ComponenteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/componentes")
public class ComponenteController {

    private final ComponenteService service;

    public ComponenteController(ComponenteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Componente> listar() {
        return service.listar();
    }

    @GetMapping("/bajo-stock")
    public List<Componente> bajoStock() {
        return service.listarBajoStock();
    }

    @GetMapping("/{codigo}")
    public Componente buscar(@PathVariable String codigo) {
        return service.buscarPorCodigo(codigo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Componente crear(@RequestBody Componente componente) {
        return service.crear(componente);
    }

    @PutMapping("/{codigo}")
    public Componente actualizar(@PathVariable String codigo, @RequestBody Componente componente) {
        return service.actualizar(codigo, componente);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable String codigo) {
        service.eliminar(codigo);
    }

    @GetMapping("/descripciones")
    public List<String> descripciones() {
        return service.describirTodos();
    }
}
