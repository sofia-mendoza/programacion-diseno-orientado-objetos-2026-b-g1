import java.util.HashSet;
import java.util.Set;

public class Numeros {
    public static void main(String[] args){

        Set<Integer> numeros = new HashSet<>();

        numeros.add(1);
        numeros.add(2);

        System.out.println(numeros);

        numeros.remove(2);

        System.out.println(numeros);
    }
}
