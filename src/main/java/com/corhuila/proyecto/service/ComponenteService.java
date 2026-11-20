package com.corhuila.proyecto.service;

import com.corhuila.proyecto.dto.CategoriaDTO;
import com.corhuila.proyecto.dto.ComponenteDTO;
import com.corhuila.proyecto.exception.ComponenteNoEncontradoException;
import com.corhuila.proyecto.mapper.ComponenteMapper;
import com.corhuila.proyecto.model.Categoria;
import com.corhuila.proyecto.model.Componente;
import com.corhuila.proyecto.repository.ComponenteRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ComponenteService {

    private final ComponenteRepository repository;
    private final int stockMinimo;

    public ComponenteService(ComponenteRepository repository,
                             @Value("${inventario.stock.minimo}") int stockMinimo) {
        this.repository = repository;
        this.stockMinimo = stockMinimo;
    }

    public List<ComponenteDTO> listar() {
        return repository.findAll().stream().map(ComponenteMapper::aDto).toList();
    }

    public Page<ComponenteDTO> listarPaginado(int page,
                                              int size,
                                              Categoria categoria,
                                              boolean soloBajoStock,
                                              String texto) {
        int paginaSegura = Math.max(0, page);
        int tamanoSeguro = Math.min(Math.max(1, size), 100);
        Pageable pageable = PageRequest.of(paginaSegura, tamanoSeguro, Sort.by("id").ascending());

        Specification<Componente> spec = (root, query, cb) -> {
            List<Predicate> filtros = new ArrayList<>();

            if (categoria != null) {
                filtros.add(cb.equal(root.get("categoria"), categoria));
            }
            if (soloBajoStock) {
                filtros.add(cb.lessThan(root.get("cantidad"), stockMinimo));
            }
            if (texto != null && !texto.isBlank()) {
                String patron = "%" + texto.trim().toLowerCase() + "%";
                filtros.add(cb.or(
                        cb.like(cb.lower(root.get("codigo")), patron),
                        cb.like(cb.lower(root.get("nombre")), patron),
                        cb.like(cb.lower(root.get("ubicacion")), patron)
                ));
            }

            return cb.and(filtros.toArray(new Predicate[0]));
        };

        return repository.findAll(spec, pageable).map(ComponenteMapper::aDto);
    }

    public ComponenteDTO buscarPorCodigo(String codigo) {
        return ComponenteMapper.aDto(obtenerEntidad(codigo));
    }

    public Componente obtenerEntidad(String codigo) {
        return repository.findByCodigo(codigo)
                .orElseThrow(() -> new ComponenteNoEncontradoException(codigo));
    }

    public List<ComponenteDTO> listarBajoStock() {
        return repository.findByCantidadLessThan(stockMinimo).stream()
                .map(ComponenteMapper::aDto).toList();
    }

    public List<String> describirTodos() {
        return repository.findAll().stream()
                .map(Componente::describir)
                .toList();
    }

    public List<CategoriaDTO> listarCategorias() {
        return Arrays.stream(Categoria.values())
                .map(c -> new CategoriaDTO(c.name(), c.getNombre(), c.getEtiquetaDetalle()))
                .toList();
    }

    public ComponenteDTO crear(ComponenteDTO dto) {
        Componente nuevo = ComponenteMapper.aEntidad(dto);
        nuevo.asignarCodigo(generarCodigo(nuevo.getCategoria()));
        return ComponenteMapper.aDto(repository.save(nuevo));
    }

    private String generarCodigo(Categoria categoria) {
        int siguiente = repository.findTopByCategoriaOrderByIdDesc(categoria)
                .map(ultimo -> numeroDe(ultimo.getCodigo()) + 1)
                .orElse(1);
        return String.format("%s-%03d", categoria.getPrefijo(), siguiente);
    }

    private int numeroDe(String codigo) {
        return Integer.parseInt(codigo.substring(codigo.indexOf('-') + 1));
    }

    public ComponenteDTO actualizar(String codigo, ComponenteDTO dto) {
        if (dto.cantidad() == null) {
            throw new IllegalArgumentException("La cantidad es obligatoria");
        }
        Componente existente = obtenerEntidad(codigo);

        existente.setNombre(dto.nombre());
        existente.setCantidad(dto.cantidad());
        existente.setUbicacion(dto.ubicacion());
        existente.setDetalle(dto.detalle());

        return ComponenteMapper.aDto(repository.save(existente));
    }

    public void eliminar(String codigo) {
        repository.delete(obtenerEntidad(codigo));
    }
}