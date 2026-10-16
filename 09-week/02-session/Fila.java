import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    public static void main(String[] args){

        Queue<Integer> fila = new LinkedList<>();

        fila.offer(1);
        fila.offer(2);
        fila.offer(3);

        fila.peek();

        System.out.println("Cantidad en espera: " + fila.size());
        while (!fila.isEmpty()) {
            Integer n = fila.poll();
            System.out.println("Se atiende a: " + n);
        }

        System.out.println("Cantidad en espera: " + fila.size());

    }
}
