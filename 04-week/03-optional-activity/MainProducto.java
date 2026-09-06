/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */
public class MainProducto {
        public static void main(String[] args) {
            System.out.println("=== 1. Creacion e Impresion de Productos ===");
            // Creación con constructor completo
            Producto p1 = new Producto("P001", "Laptop", 1200000.0, 10);
            Producto p2 = new Producto("P002", "Teclado", 80000.0, 25);

            // Creación con constructor secundario (precio y stock en 0)
            Producto p3 = new Producto("P001", "Laptop Pro", 1500000.0, 5);

            System.out.println("p1: " + p1);
            System.out.println("p2: " + p2);
            System.out.println("p3: " + p3);

            System.out.println("\n=== 2. Prueba de equals() por codigo ===");
            // Comparación de dos productos con el mismo código "P001"
            boolean sonIguales = p1.equals(p3);
            System.out.println("¿p1 es igual a p3? (mismo codigo 'P001'): " + sonIguales);

            System.out.println("\n=== 3. Prueba con HashSet (Evidencia de No Duplicados) ===");
            // Uso de HashSet haciendo referencia directa a su paquete sin import
            java.util.HashSet<Producto> setProductos = new java.util.HashSet<>();

            boolean agregoP1 = setProductos.add(p1);
            boolean agregoP2 = setProductos.add(p2);
            boolean agregoP3 = setProductos.add(p3); // Se rechaza porque p1 ya existe con codigo "P001"

            System.out.println("¿Se agrego p1?: " + agregoP1); // true
            System.out.println("¿Se agrego p2?: " + agregoP2); // true
            System.out.println("¿Se agrego p3?: " + agregoP3); // false (demuestra que no se duplica)

            System.out.println("\nContenido final del HashSet (" + setProductos.size() + " elementos):");
            for (Producto prod : setProductos) {
                System.out.println(prod);
            }
        }
    }
