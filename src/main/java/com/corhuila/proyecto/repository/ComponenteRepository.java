package com.corhuila.proyecto.repository;

import com.corhuila.proyecto.model.Categoria;
import com.corhuila.proyecto.model.Componente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ComponenteRepository extends JpaRepository<Componente, Long>, JpaSpecificationExecutor<Componente> {
    Optional<Componente> findByCodigo(String codigo);
    boolean existsByCodigo(String codigo);
    List<Componente> findByCantidadLessThan(int cantidad);
    Optional<Componente> findTopByCategoriaOrderByIdDesc(Categoria categoria);
}