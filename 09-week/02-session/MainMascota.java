import java.util.ArrayList;

public class MainMascota {
    public static void main(String[] args) {

        // 1. Crear la lista
        ArrayList<Mascota> mascotas = new ArrayList<>();

        // 2. Agregar mascotas
        mascotas.add(new Mascota("Firulais", 3));
        mascotas.add(new Mascota("Michi", 4));
        mascotas.add(new Mascota("Rex", 5));

        // 3. Mostrar todas
        System.out.println("Lista de mascotas:");
        for (Mascota m : mascotas) {
            System.out.println(m);
        }

        // 4. Obtener una por índice
        System.out.println("Primera: " + mascotas.get(0).getNombre());

        // 5. Calcular la edad promedio
        double suma = 0;
        for (Mascota m : mascotas) {
            suma += m.getEdad();
        }
        System.out.println("Edad promedio: " + suma / mascotas.size());

        // 6. Buscar por nombre
        for (Mascota m : mascotas) {
            if (m.getNombre().equals("Michi")) {
                System.out.println("Encontrada: " + m);
            }
        }

        // 7. Eliminar por índice
        mascotas.remove(1);   // elimina a Michi
        System.out.println("Quedan: " + mascotas.size());
    }
}
