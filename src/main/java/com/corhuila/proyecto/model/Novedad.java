package com.corhuila.proyecto.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// Registro de un componente dañado, extraviado o fuera de servicio
@Entity
public class Novedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "componente_id")
    private Componente componente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoNovedad tipo;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false, length = 500)
    private String descripcion;

    // Fecha y hora: las pone el sistema
    @Column(nullable = false)
    private LocalDateTime fechaHora;

    protected Novedad() {
    }

    public Novedad(Componente componente, TipoNovedad tipo, int cantidad, String descripcion) {
        if (componente == null) {
            throw new IllegalArgumentException("El componente es obligatorio");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de novedad es obligatorio");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad afectada debe ser mayor que 0");
        }
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        this.componente = componente;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.descripcion = descripcion.trim();
        this.fechaHora = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Componente getComponente() { return componente; }
    public TipoNovedad getTipo() { return tipo; }
    public int getCantidad() { return cantidad; }
    public String getDescripcion() { return descripcion; }
    public LocalDateTime getFechaHora() { return fechaHora; }
}
