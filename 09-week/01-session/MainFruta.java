import java.util.List;

public class MainFruta {
    public static void main (String[] args){
        List<String> frutas = List.of("Manzana", "Pera", "Mango", "Uva", "Pera");

        System.out.println("Frutas " + frutas);
        System.out.println("Primera: " + frutas.get(0));
        System.out.println("Cantidad: " + frutas.size());
        System.out.println("Hay mango? " + frutas.contains("Mango"));
        System.out.println("Posición de Uva: " + frutas.indexOf("Uva"));
    }
}
