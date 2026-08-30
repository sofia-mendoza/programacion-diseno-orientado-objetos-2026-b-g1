/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */

public class MainLibro {
    public static void main(String[] args) {
        System.out.println("=== 1. TRES OBJETOS CON ESTADO INDEPENDIENTE ===");
        Libro libro1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 471);
        Libro libro2 = new Libro("El Principito", "Antoine de Saint-Exupéry", 96);
        Libro libro3 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 863);

        libro1.describir();
        System.out.println("¿Es largo?: " + libro1.esLargo());

        libro2.describir();
        System.out.println("¿Es largo?: " + libro2.esLargo());

        libro3.describir();
        System.out.println("¿Es largo?: " + libro3.esLargo());

        System.out.println("\n=== 2. DEMOSTRACIÓN DE ALIASING ===");
        // Asignamos libro1 a una segunda variable
        Libro otro = libro1;

        System.out.println("Título original de libro1: " + libro1.titulo);
        System.out.println("Modificando título desde la variable 'otro'...");
        otro.titulo = "Cien Años de Soledad (Edición Especial)";

        // Comprobamos que libro1 también vio el cambio
        System.out.println("Nuevo título leído desde libro1: " + libro1.titulo);

        System.out.println("\n=== 3. MANEJO DE NULLPOINTEREXCEPTION ===");
        Libro libroNulo = null;

        // Prevención del error con condición if != null
        System.out.println("Intentando acceder a la referencia nula (protegida con if != null):");
        if (libroNulo != null) {
            libroNulo.describir();
        } else {
            System.out.println("El libro está en null. Se evitó el fallo por NullPointerException.");
        }
    }
}