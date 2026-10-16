import java.util.ArrayList;

public class MainMascota {
    public static void main(String[] args) {


        ArrayList<Mascota> mascotas = new ArrayList<>();


        mascotas.add(new Mascota("Firulais", 3));
        mascotas.add(new Mascota("Michi", 4));
        mascotas.add(new Mascota("Rex", 5));


        System.out.println("Lista de mascotas:");
        for (Mascota m : mascotas) {
            System.out.println(m);
        }


        System.out.println("Primera: " + mascotas.get(0).getNombre());


        double suma = 0;
        for (Mascota m : mascotas) {
            suma += m.getEdad();
        }
        System.out.println("Edad promedio: " + suma / mascotas.size());


        for (Mascota m : mascotas) {
            if (m.getNombre().equals("Michi")) {
                System.out.println("Encontrada: " + m);
            }
        }


        mascotas.remove(1);
        System.out.println("Quedan: " + mascotas.size());
    }
}
