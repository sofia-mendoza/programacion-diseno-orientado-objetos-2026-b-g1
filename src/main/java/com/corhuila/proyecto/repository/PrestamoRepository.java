package com.corhuila.proyecto.repository;

import com.corhuila.proyecto.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    // Los más recientes primero
    List<Prestamo> findAllByOrderByFechaHoraPrestamoDesc();
}
