/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class MainVehiculo {

    public static void main(String[] args) {

        CarroDeportivo miCarro = new CarroDeportivo("Ferrari", 4, 1000);
        miCarro.drive();
        miCarro.stop();
        miCarro.activarModoTurbo();


        ServicioPublico miServicio = new ServicioPublico("Marcoolo", 4, 63);
        miServicio.drive();
        miServicio.mostrarRuta();


        Avion miAvion = new Avion("Boeing", 6, true);
        miAvion.stop();
        miAvion.despegar();
    }

}

