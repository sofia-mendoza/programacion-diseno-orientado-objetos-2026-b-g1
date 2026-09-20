/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class CarroDeportivo extends Vehiculo {
    private int potencia;

    public CarroDeportivo(String marca, int llantas, int potencia) {
        super(marca, llantas);
        this.potencia = potencia;
    }

    public void activarModoTurbo() {
        System.out.println("El " + marca + " tiene " + llantas + " llantas y activó modo turbo con una potencia de " + potencia + " caballos de fuerza.");
    }

}
