package com.corhuila.proyecto.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Kit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    // Composición: el kit contiene componentes
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "kit_componente",
            joinColumns = @JoinColumn(name = "kit_id"),
            inverseJoinColumns = @JoinColumn(name = "componente_id"))
    private List<Componente> componentes = new ArrayList<>();

    protected Kit() {
    }

    public Kit(String nombre) {
        setNombre(nombre);
    }

    public Long getId() { return id; }
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }

    // Se devuelve una vista de solo lectura: nadie de afuera modifica la lista directamente
    public List<Componente> getComponentes() {
        return Collections.unmodifiableList(componentes);
    }

    // Solo el servicio asigna el código (automático), una única vez
    public void asignarCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código del kit no puede estar vacío");
        }
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del kit no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public void agregarComponente(Componente componente) {
        if (componentes.contains(componente)) {
            throw new IllegalArgumentException(
                    "El componente " + componente.getCodigo() + " ya está en el kit");
        }
        componentes.add(componente);
    }

    public void quitarComponente(Componente componente) {
        if (!componentes.remove(componente)) {
            throw new IllegalArgumentException(
                    "El componente " + componente.getCodigo() + " no está en el kit");
        }
    }
}
