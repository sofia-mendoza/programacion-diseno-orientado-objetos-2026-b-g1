import java.io.FileNotFoundException;
import java.io.FileReader;

public class MainExcepciones {

    static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0) throw new EdadInvalidaException("La edad no puede ser negativa: " + edad);
    }

    public static void main(String[] args) {
        ManejadorExcepciones manejador = new ManejadorExcepciones();
        int[] a = new int[3];
        for (int caso = 1; caso <= 5; caso++) {
            System.out.println("--- Prueba " + caso + " ---");
            try {
                if (caso == 1) System.out.println(10 / 0);
                if (caso == 2) a[5] = 1;
                if (caso == 3) Integer.parseInt("abc");
                if (caso == 4) new FileReader("no_existe.txt");
                if (caso == 5) validarEdad(-5);
            } catch (ArithmeticException e) {
                manejador.manejarAritmetica(e);
            } catch (ArrayIndexOutOfBoundsException e) {
                manejador.manejarIndice(e);
            } catch (NumberFormatException e) {
                manejador.manejarFormato(e);
            } catch (FileNotFoundException e) {
                manejador.manejarArchivo(e);
            } catch (EdadInvalidaException e) {
                manejador.manejarEdad(e);
            } finally {
                System.out.println("Bloque finally: se ejecuta siempre.\n");
            }
        }
    }
}