/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Vehiculo {

    protected String marca;
    protected int llantas;

    public Vehiculo(String marca, int llantas) {
        this.marca = marca;
        this.llantas = llantas;
    }

    public void drive() {
        System.out.println("El vehículo está en movimiento.");
    }

    public void stop() {
        System.out.println("El vehículo se ha detenido.");
    }
}
