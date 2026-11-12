package com.corhuila.proyecto.service;

import com.corhuila.proyecto.exception.ComponenteDuplicadoException;
import com.corhuila.proyecto.exception.ComponenteNoEncontradoException;
import com.corhuila.proyecto.model.Actuador;
import com.corhuila.proyecto.model.Componente;
import com.corhuila.proyecto.model.Sensor;
import com.corhuila.proyecto.repository.ComponenteRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponenteService {

    private final ComponenteRepository repository;
    private final int stockMinimo;

    public ComponenteService(ComponenteRepository repository,
                             @Value("${inventario.stock.minimo}") int stockMinimo) {
        this.repository = repository;
        this.stockMinimo = stockMinimo;
    }

    public List<Componente> listar() {
        return repository.findAll();
    }

    public Componente buscarPorCodigo(String codigo) {
        return repository.findByCodigo(codigo)
                .orElseThrow(() -> new ComponenteNoEncontradoException(codigo));
    }

    public List<Componente> listarBajoStock() {
        return repository.findByCantidadLessThan(stockMinimo);
    }

    public Componente crear(Componente nuevo) {
        if (repository.existsByCodigo(nuevo.getCodigo())) {
            throw new ComponenteDuplicadoException(nuevo.getCodigo());
        }
        return repository.save(nuevo);
    }

    public Componente actualizar(String codigo, Componente datos) {
        Componente existente = buscarPorCodigo(codigo);

        existente.setNombre(datos.getNombre());
        existente.setCantidad(datos.getCantidad());
        existente.setUbicacion(datos.getUbicacion());

        if (existente instanceof Sensor sensor && datos instanceof Sensor nuevo) {
            sensor.setMagnitud(nuevo.getMagnitud());
        } else if (existente instanceof Actuador actuador && datos instanceof Actuador nuevo) {
            actuador.setVoltaje(nuevo.getVoltaje());
        }
        return repository.save(existente);
    }

    public void eliminar(String codigo) {
        repository.delete(buscarPorCodigo(codigo));
    }
}