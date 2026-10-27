import java.io.FileNotFoundException;

public class ManejadorExcepciones {

    public void manejarAritmetica(ArithmeticException e) {
        System.out.println("[ArithmeticException] No se puede dividir entre cero.");
        System.out.println("Detalle: " + e.getMessage());
    }

    public void manejarIndice(ArrayIndexOutOfBoundsException e) {
        System.out.println("[ArrayIndexOutOfBoundsException] Posición fuera del arreglo.");
        System.out.println("Detalle: " + e.getMessage());
    }

    public void manejarFormato(NumberFormatException e) {
        System.out.println("[NumberFormatException] El texto no se puede convertir a número.");
        System.out.println("Detalle: " + e.getMessage());
    }

    public void manejarArchivo(FileNotFoundException e) {
        System.out.println("[FileNotFoundException] El archivo no existe o no se puede abrir.");
        System.out.println("Detalle: " + e.getMessage());
    }
}
