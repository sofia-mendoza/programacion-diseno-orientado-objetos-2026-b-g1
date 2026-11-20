package com.corhuila.proyecto.config;

import com.corhuila.proyecto.dto.ComponenteDTO;
import com.corhuila.proyecto.model.Categoria;
import com.corhuila.proyecto.repository.ComponenteRepository;
import com.corhuila.proyecto.service.ComponenteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Carga datos de ejemplo la primera vez que arranca (solo si la tabla está vacía)
@Component
public class CargaInicial implements CommandLineRunner {

    private final ComponenteRepository repository;
    private final ComponenteService service;

    public CargaInicial(ComponenteRepository repository, ComponenteService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public void run(String... args) {
        if (repository.count() > 0) {
            return;
        }

        // Mecánica y sistemas de potencia (detalle = material)
        agregar(Categoria.MECANICA_POTENCIA, "Engranaje recto de 20 dientes", 14, "Estante A1", "acero");
        agregar(Categoria.MECANICA_POTENCIA, "Rodamiento 608", 30, "Estante A1", "acero");
        agregar(Categoria.MECANICA_POTENCIA, "Eje de 8 mm", 10, "Estante A1", "acero inoxidable");
        agregar(Categoria.MECANICA_POTENCIA, "Polea GT2", 12, "Estante A2", "aluminio");
        agregar(Categoria.MECANICA_POTENCIA, "Correa dentada GT2", 4, "Estante A2", "caucho");
        agregar(Categoria.MECANICA_POTENCIA, "Cilindro neumático", 3, "Estante A2", "aluminio");
        agregar(Categoria.MECANICA_POTENCIA, "Compresor de aire", 1, "Taller 3", "acero");

        // Electrónica e instrumentación (detalle = magnitud que mide o maneja)
        agregar(Categoria.ELECTRONICA_INSTRUMENTACION, "Multímetro digital", 4, "Estante B1", "voltaje y corriente");
        agregar(Categoria.ELECTRONICA_INSTRUMENTACION, "Osciloscopio", 2, "Estante B1", "señales eléctricas");
        agregar(Categoria.ELECTRONICA_INSTRUMENTACION, "Sensor ultrasónico HC-SR04", 10, "Estante B2", "distancia");
        agregar(Categoria.ELECTRONICA_INSTRUMENTACION, "LM35", 8, "Estante B2", "temperatura");
        agregar(Categoria.ELECTRONICA_INSTRUMENTACION, "DHT11", 6, "Estante B2", "temperatura y humedad");
        agregar(Categoria.ELECTRONICA_INSTRUMENTACION, "Fotorresistencia LDR", 15, "Estante B3", "luz");
        agregar(Categoria.ELECTRONICA_INSTRUMENTACION, "Acelerómetro MPU6050", 4, "Estante B3", "aceleración");

        // Automatización y control (detalle = voltaje de operación en V)
        agregar(Categoria.AUTOMATIZACION_CONTROL, "PLC LOGO!", 2, "Estante C1", "24");
        agregar(Categoria.AUTOMATIZACION_CONTROL, "Relé industrial", 10, "Estante C1", "24");
        agregar(Categoria.AUTOMATIZACION_CONTROL, "Contactor", 4, "Estante C1", "220");
        agregar(Categoria.AUTOMATIZACION_CONTROL, "Pantalla HMI", 1, "Estante C2", "24");
        agregar(Categoria.AUTOMATIZACION_CONTROL, "Sensor inductivo", 8, "Estante C2", "12");
        agregar(Categoria.AUTOMATIZACION_CONTROL, "Electroválvula 5/2", 3, "Estante C2", "24");
        agregar(Categoria.AUTOMATIZACION_CONTROL, "Fuente conmutada de 24 V", 4, "Estante C3", "24");

        // Robótica (detalle = controlador compatible)
        agregar(Categoria.ROBOTICA, "Brazo robótico de 4 ejes", 2, "Estante D1", "Arduino");
        agregar(Categoria.ROBOTICA, "Chasis de robot 4WD", 3, "Estante D1", "Arduino");
        agregar(Categoria.ROBOTICA, "Servo SG90", 15, "Estante D2", "Arduino");
        agregar(Categoria.ROBOTICA, "Servo MG996R", 5, "Estante D2", "Arduino");
        agregar(Categoria.ROBOTICA, "Driver de motores L298N", 9, "Estante D2", "Arduino");
        agregar(Categoria.ROBOTICA, "Kit seguidor de línea", 3, "Estante D3", "Arduino");
        agregar(Categoria.ROBOTICA, "Cámara para visión robótica", 2, "Estante D3", "Raspberry Pi");

        // Prototipado, manufactura y software (detalle = marca o proveedor)
        agregar(Categoria.PROTOTIPADO_MANUFACTURA, "Impresora 3D", 3, "Taller 1", "Creality");
        agregar(Categoria.PROTOTIPADO_MANUFACTURA, "Cortadora láser", 1, "Taller 1", "xTool");
        agregar(Categoria.PROTOTIPADO_MANUFACTURA, "Fresadora CNC", 1, "Taller 2", "Sainsmart");
        agregar(Categoria.PROTOTIPADO_MANUFACTURA, "Torno de mesa", 1, "Taller 2", "Proxxon");
        agregar(Categoria.PROTOTIPADO_MANUFACTURA, "Soldador de estaño", 6, "Taller 3", "Hakko");
        agregar(Categoria.PROTOTIPADO_MANUFACTURA, "Licencia SolidWorks", 15, "Software", "Dassault Systèmes");
        agregar(Categoria.PROTOTIPADO_MANUFACTURA, "Licencia MATLAB", 20, "Software", "MathWorks");
    }

    private void agregar(Categoria categoria, String nombre, int cantidad, String ubicacion, String detalle) {
        service.crear(new ComponenteDTO(null, categoria.name(), null, nombre, cantidad, ubicacion, detalle));
    }
}
