package com.corhuila.proyecto.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Cada préstamo es de un componente
    @ManyToOne(optional = false)
    @JoinColumn(name = "componente_id")
    private Componente componente;

    @Column(nullable = false)
    private String solicitante;

    @Column(nullable = false)
    private int cantidad;

    // Fecha y hora de salida: las pone el sistema, no el operario
    @Column(nullable = false)
    private LocalDateTime fechaHoraPrestamo;

    private LocalDateTime fechaHoraDevolucion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPrestamo estado;

    protected Prestamo() {
    }

    public Prestamo(Componente componente, String solicitante, int cantidad) {
        if (componente == null) {
            throw new IllegalArgumentException("El componente es obligatorio");
        }
        if (solicitante == null || solicitante.isBlank()) {
            throw new IllegalArgumentException("El nombre de quien solicita no puede estar vacío");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad prestada debe ser mayor que 0");
        }
        this.componente = componente;
        this.solicitante = solicitante.trim();
        this.cantidad = cantidad;
        this.fechaHoraPrestamo = LocalDateTime.now();
        this.estado = EstadoPrestamo.PRESTADO;
    }

    // Un préstamo solo se puede devolver una vez
    public void registrarDevolucion() {
        if (estado == EstadoPrestamo.DEVUELTO) {
            throw new IllegalArgumentException("Este préstamo ya fue devuelto");
        }
        this.estado = EstadoPrestamo.DEVUELTO;
        this.fechaHoraDevolucion = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Componente getComponente() { return componente; }
    public String getSolicitante() { return solicitante; }
    public int getCantidad() { return cantidad; }
    public LocalDateTime getFechaHoraPrestamo() { return fechaHoraPrestamo; }
    public LocalDateTime getFechaHoraDevolucion() { return fechaHoraDevolucion; }
    public EstadoPrestamo getEstado() { return estado; }
}
