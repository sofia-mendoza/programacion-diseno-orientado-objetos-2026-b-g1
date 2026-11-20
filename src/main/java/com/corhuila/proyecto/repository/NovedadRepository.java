package com.corhuila.proyecto.repository;

import com.corhuila.proyecto.model.Novedad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NovedadRepository extends JpaRepository<Novedad, Long> {

    // Las más recientes primero
    List<Novedad> findAllByOrderByFechaHoraDesc();
}
