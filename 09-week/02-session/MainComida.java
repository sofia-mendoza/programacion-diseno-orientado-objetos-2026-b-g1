import java.util.ArrayList;

public class MainComida {
    public static void main(String[] args) {

        ArrayList<String> comidas = new ArrayList<>();

        comidas.add("Pizza");
        comidas.add("Arepa");
        comidas.add("Sancocho");


        System.out.println(comidas);


        System.out.println(comidas.get(1));


        System.out.println(comidas.size());


        comidas.remove("Pizza");


        for (String comida : comidas) {
            System.out.println("Me gusta: " + comida);
        }
    }
}