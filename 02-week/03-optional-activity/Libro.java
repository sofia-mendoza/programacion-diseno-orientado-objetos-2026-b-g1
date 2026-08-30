/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */

public class Libro {
    // Atributos de la clase
    public String titulo;
    public String autor;
    public int paginas;

    // Constructor: usa 'this' para asignar los valores recibidos a los atributos
    public Libro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    // Método para imprimir la información del libro
    public void describir() {
        System.out.println("Título: " + this.titulo + " | Autor: " + this.autor + " | Páginas: " + this.paginas);
    }

    // Método que evalúa si el libro supera las 300 páginas
    public boolean esLargo() {
        return this.paginas > 300;
    }
}