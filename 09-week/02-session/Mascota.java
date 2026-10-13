public class Mascota {
    private String nombre;
    private int edad;

    // Constructor: se ejecuta al crear una mascota
    public Mascota(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters: permiten leer los atributos privados
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Define cómo se muestra la mascota al imprimirla
    @Override
    public String toString() {
        return nombre + " - Edad: " + edad + " años";
    }
}