package com.corhuila.proyecto.controller;

import com.corhuila.proyecto.dto.CategoriaDTO;
import com.corhuila.proyecto.dto.ComponenteDTO;
import com.corhuila.proyecto.model.Categoria;
import com.corhuila.proyecto.service.ComponenteService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/componentes")
public class ComponenteController {

    private final ComponenteService service;

    public ComponenteController(ComponenteService service) {
        this.service = service;
    }

    @GetMapping
    public Page<ComponenteDTO> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            @RequestParam(required = false) Categoria categoria,
            @RequestParam(defaultValue = "false") boolean soloBajoStock,
            @RequestParam(required = false) String q
    ) {
        return service.listarPaginado(page, size, categoria, soloBajoStock, q);
    }

    @GetMapping("/categorias")
    public List<CategoriaDTO> categorias() {
        return service.listarCategorias();
    }

    @GetMapping("/bajo-stock")
    public List<ComponenteDTO> bajoStock() {
        return service.listarBajoStock();
    }

    @GetMapping("/descripciones")
    public List<String> descripciones() {
        return service.describirTodos();
    }

    @GetMapping("/{codigo}")
    public ComponenteDTO buscar(@PathVariable String codigo) {
        return service.buscarPorCodigo(codigo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComponenteDTO crear(@RequestBody ComponenteDTO dto) {
        return service.crear(dto);
    }

    @PutMapping("/{codigo}")
    public ComponenteDTO actualizar(@PathVariable String codigo, @RequestBody ComponenteDTO dto) {
        return service.actualizar(codigo, dto);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable String codigo) {
        service.eliminar(codigo);
    }
}
