import java.util.LinkedList;

public class Lista {
    public static void main (String[] args){
        LinkedList<String> lista = new LinkedList<>();

        lista.add("Java");
        lista.add("Python");
        lista.addFirst("C++");

        System.out.println("Listas enlazadas: " + lista);
        System.out.println("Primer elemento: " + lista.peekFirst());
    }
}
