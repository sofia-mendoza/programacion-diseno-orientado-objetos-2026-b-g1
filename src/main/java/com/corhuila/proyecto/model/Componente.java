package com.corhuila.proyecto.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Sensor.class, name = "SENSOR"),
        @JsonSubTypes.Type(value = Actuador.class, name = "ACTUADOR")
})
public abstract class Componente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private String ubicacion;

    // Spring/JPA necesita este constructor vacío
    protected Componente() {
    }

    protected Componente(String codigo, String nombre, int cantidad, String ubicacion) {
        setCodigo(codigo);
        setNombre(nombre);
        setCantidad(cantidad);
        setUbicacion(ubicacion);
    }

    // Cada hijo lo describe a su manera (polimorfismo)
    public abstract String describir();

    public Long getId() { return id; }
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public String getUbicacion() { return ubicacion; }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        this.cantidad = cantidad;
    }

    public void setUbicacion(String ubicacion) {
        if (ubicacion == null || ubicacion.isBlank()) {
            throw new IllegalArgumentException("La ubicación no puede estar vacía");
        }
        this.ubicacion = ubicacion;
    }
}