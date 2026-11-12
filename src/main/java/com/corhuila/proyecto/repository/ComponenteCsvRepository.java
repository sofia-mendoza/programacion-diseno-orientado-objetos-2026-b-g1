package com.corhuila.proyecto.repository;

import com.corhuila.proyecto.exception.ArchivoCsvException;
import com.corhuila.proyecto.model.Actuador;
import com.corhuila.proyecto.model.Componente;
import com.corhuila.proyecto.model.Sensor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ComponenteCsvRepository {

    private static final String SEPARADOR = ";";
    private static final String ENCABEZADO = "tipo;codigo;nombre;cantidad;ubicacion;extra";
    private static final int COLUMNAS = 6;

    private final Path ruta;

    public ComponenteCsvRepository(@Value("${respaldo.ruta}") String ruta) {
        this.ruta = Path.of(ruta);
    }

    public void guardar(List<Componente> componentes) {
        List<String> lineas = new ArrayList<>();
        lineas.add(ENCABEZADO);
        for (Componente componente : componentes) {
            lineas.add(aLinea(componente));
        }
        try {
            Path carpeta = ruta.toAbsolutePath().getParent();
            if (carpeta != null) {
                Files.createDirectories(carpeta);
            }
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ArchivoCsvException("No se pudo escribir el archivo: " + ruta, e);
        }
    }

    public List<Componente> cargar() {
        if (!Files.exists(ruta)) {
            throw new ArchivoCsvException("No existe el archivo de respaldo: " + ruta, null);
        }
        List<String> lineas;
        try {
            lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ArchivoCsvException("No se pudo leer el archivo: " + ruta, e);
        }

        List<Componente> componentes = new ArrayList<>();
        // La línea 1 es el encabezado, por eso se empieza en la 2
        for (int i = 1; i < lineas.size(); i++) {
            if (lineas.get(i).isBlank()) {
                continue;
            }
            try {
                componentes.add(aComponente(lineas.get(i)));
            } catch (IllegalArgumentException e) {
                throw new ArchivoCsvException("Línea " + (i + 1) + " inválida: " + e.getMessage(), e);
            }
        }
        return componentes;
    }

    private String aLinea(Componente componente) {
        String tipo;
        String extra;
        if (componente instanceof Sensor sensor) {
            tipo = "SENSOR";
            extra = sensor.getMagnitud();
        } else if (componente instanceof Actuador actuador) {
            tipo = "ACTUADOR";
            extra = String.valueOf(actuador.getVoltaje());
        } else {
            throw new IllegalStateException("Tipo de componente no soportado");
        }
        return String.join(SEPARADOR, tipo,
                limpiar(componente.getCodigo()),
                limpiar(componente.getNombre()),
                String.valueOf(componente.getCantidad()),
                limpiar(componente.getUbicacion()),
                limpiar(extra));
    }

    private Componente aComponente(String linea) {
        String[] partes = linea.split(SEPARADOR, -1);
        if (partes.length != COLUMNAS) {
            throw new IllegalArgumentException("se esperaban " + COLUMNAS + " columnas");
        }
        String tipo = partes[0].trim();
        String codigo = partes[1].trim();
        String nombre = partes[2].trim();
        int cantidad = Integer.parseInt(partes[3].trim());
        String ubicacion = partes[4].trim();
        String extra = partes[5].trim();

        return switch (tipo) {
            case "SENSOR" -> new Sensor(codigo, nombre, cantidad, ubicacion, extra);
            case "ACTUADOR" -> new Actuador(codigo, nombre, cantidad, ubicacion, Double.parseDouble(extra));
            default -> throw new IllegalArgumentException("tipo desconocido: " + tipo);
        };
    }

    // Evita que un texto con ";" o salto de línea rompa el formato del archivo
    private String limpiar(String texto) {
        return texto.replace(SEPARADOR, ",").replace("\n", " ");
    }
}