/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class ServicioPublico extends Vehiculo {
    private int ruta;

    public ServicioPublico(String marca, int llantas, int ruta) {
        super(marca, llantas);
        this.ruta = ruta;
    }

    public void mostrarRuta() {
        System.out.println("El bus " + marca + " tene " + llantas + " llantas y sigue la ruta " + ruta);
    }
}
