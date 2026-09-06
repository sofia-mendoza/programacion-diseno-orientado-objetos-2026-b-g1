/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class MainTermostato {
        public static void main(String[] args) {
            System.out.println("=== 1. CREACION Y USO DE CONSTRUCTORES ===");
            Termostato t1 = new Termostato("TERM-01", "Sala de Estar", 22.5);
            Termostato t2 = new Termostato("TERM-02", "Habitacion Principal"); // Usa constructor reducido (20.0°C)
            Termostato t3 = new Termostato("TERM-01", "Oficina", 25.0); // Mismo ID que t1

            System.out.println("t1: " + t1);
            System.out.println("t2: " + t2);

            System.out.println("\n=== 2. OPERACIONES DE DOMINIO Y CASOS LIMITE VÁLIDOS ===");
            t1.subirTemperatura(7.5); // 22.5 + 7.5 = 30.0 (Límite Máximo)
            System.out.println("t1 despues de subir a limite maximo: " + t1.getTemperatura() + "°C");

            t2.bajarTemperatura(10.0); // 20.0 - 10.0 = 10.0 (Límite Mínimo)
            System.out.println("t2 despues de bajar a limite minimo: " + t2.getTemperatura() + "°C");

            System.out.println("\n=== 3. PRUEBAS DE VIOLACION DE INVARIANTE (EXCEPCIONES) ===");

            // Caso Inválido A: Intentar superar el límite máximo de 30°C
            try {
                System.out.println("Intentando subir t1 en 0.5°C mas (excederia 30°C)...");
                t1.subirTemperatura(0.5);
            } catch (IllegalStateException e) {
                System.out.println("Excepcion capturada correctamente: " + e.getMessage());
            }

            // Caso Inválido B: Crear termostato fuera de rango
            try {
                System.out.println("Intentando crear termostato a 5.0°C...");
                Termostato invalido = new Termostato("TERM-99", "Bodega", 5.0);
            } catch (IllegalArgumentException e) {
                System.out.println("Excepcion capturada correctamente: " + e.getMessage());
            }

            System.out.println("\n=== 4. PRUEBA DE IGUALDAD Y HASHSET ===");
            System.out.println("¿t1 es igual a t3? (mismo ID 'TERM-01'): " + t1.equals(t3));

            java.util.HashSet<Termostato> conjunto = new java.util.HashSet<>();
            System.out.println("Agregando t1 (TERM-01): " + conjunto.add(t1));
            System.out.println("Agregando t2 (TERM-02): " + conjunto.add(t2));
            System.out.println("Agregando t3 (TERM-01 - Duplicado): " + conjunto.add(t3));

            System.out.println("\nContenido del HashSet (" + conjunto.size() + " elementos):");
            for (Termostato t : conjunto) {
                System.out.println(t);
            }
        }
    }

