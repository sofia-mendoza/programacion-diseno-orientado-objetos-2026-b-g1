package com.corhuila.proyecto.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ManejadorErrores {

    @ExceptionHandler(ComponenteNoEncontradoException.class)
    public ResponseEntity<Map<String, String>> noEncontrado(ComponenteNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(KitNoEncontradoException.class)
    public ResponseEntity<Map<String, String>> kitNoEncontrado(KitNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(PrestamoNoEncontradoException.class)
    public ResponseEntity<Map<String, String>> prestamoNoEncontrado(PrestamoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(ComponenteDuplicadoException.class)
    public ResponseEntity<Map<String, String>> duplicado(ComponenteDuplicadoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(StockInsuficienteException.class)
    public ResponseEntity<Map<String, String>> stockInsuficiente(StockInsuficienteException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> datoInvalido(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> cuerpoInvalido(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", String.valueOf(ex.getMostSpecificCause().getMessage())));
    }

    // Por ejemplo: borrar un componente que tiene préstamos, novedades o está en un kit
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> integridad(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("error", "No se puede completar la operación: el registro está en uso (kits, préstamos o novedades) o duplicado"));
    }
}
