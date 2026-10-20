import java.util.HashMap;
import java.util.Map;

public class Estudiantes {
    public static void main(String[] args){
        Map<Integer, String> estudiantes = new HashMap<>();

        estudiantes.put(1, "Ana");
        estudiantes.put(2, "Juan");

        System.out.println(estudiantes);
    }
}
