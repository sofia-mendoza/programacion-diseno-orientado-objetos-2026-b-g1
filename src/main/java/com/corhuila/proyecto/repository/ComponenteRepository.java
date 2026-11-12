package com.corhuila.proyecto.repository;

import com.corhuila.proyecto.model.Componente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComponenteRepository extends JpaRepository<Componente, Long> {

    Optional<Componente> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);

    List<Componente> findByCantidadLessThan(int cantidad);
}