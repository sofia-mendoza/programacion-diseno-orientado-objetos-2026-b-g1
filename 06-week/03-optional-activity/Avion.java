/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Avion extends Vehiculo {
    private boolean enVuelo;

    public Avion(String marca, int llantas, boolean enVuelo) {
        super(marca, llantas);
        this.enVuelo = enVuelo;
    }

    public void despegar() {
        if (!enVuelo) {
            enVuelo = true;
            System.out.println("El avión " + marca + " tiene " + llantas + " llantas y ha despegado.");
        }
        else {
            System.out.println("El avión " + marca + " tiene " + llantas + " llantas y se encuentra en tierra.");
        }
    }

}