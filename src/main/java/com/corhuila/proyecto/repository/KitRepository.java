package com.corhuila.proyecto.repository;

import com.corhuila.proyecto.model.Kit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KitRepository extends JpaRepository<Kit, Long> {

    Optional<Kit> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);
}