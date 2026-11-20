package com.corhuila.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Componente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // El código lo genera el sistema (no lo escribe el operario)
    @Column(nullable = false, unique = true)
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private String ubicacion;

    // Spring/JPA necesita este constructor vacío
    protected Componente() {
    }

    protected Componente(Categoria categoria, String nombre, int cantidad, String ubicacion) {
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría es obligatoria");
        }
        this.categoria = categoria;
        setNombre(nombre);
        setCantidad(cantidad);
        setUbicacion(ubicacion);
    }

    // Cada categoría describe a su manera (polimorfismo)
    public abstract String describir();

    // Dato propio de cada categoría (material, magnitud, voltaje, controlador, marca)
    public abstract String getDetalle();

    public abstract void setDetalle(String detalle);

    public Long getId() { return id; }
    public String getCodigo() { return codigo; }
    public Categoria getCategoria() { return categoria; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public String getUbicacion() { return ubicacion; }

    // Solo el servicio asigna el código, una única vez
    public void asignarCodigo(String codigo) {
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

    // Convierte el texto que llega del formulario en número, con un mensaje claro si falla
    protected static double aNumero(String texto, String campo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("El campo " + campo + " es obligatorio");
        }
        try {
            return Double.parseDouble(texto.trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El campo " + campo + " debe ser un número");
        }
    }
}
