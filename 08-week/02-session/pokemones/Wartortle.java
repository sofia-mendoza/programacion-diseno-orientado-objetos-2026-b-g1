package pokemones;

import base.Pokemones;
import interfaces.InterfaceAgua;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Wartortle extends Pokemones implements InterfaceAgua {
    public Wartortle() { super(); }
    public Wartortle(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Wartortle usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Wartortle usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Wartortle usa Arañazo."); }

    @Override public void atacarPistolaAgua() { System.out.println("Wartortle usa Pistola Agua!"); }
    @Override public void atacarHidrobomba() { System.out.println("Wartortle usa Hidrobomba!"); }
    @Override public void atacarBurbuja() { System.out.println("Wartortle usa Burbuja!"); }
}
