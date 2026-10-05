package pokemones;

import base.Pokemones;
import interfaces.InterfaceAgua;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Squirtle extends Pokemones implements InterfaceAgua {
    public Squirtle() { super(); }
    public Squirtle(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Squirtle usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Squirtle usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Squirtle usa Arañazo."); }

    @Override public void atacarPistolaAgua() { System.out.println("Squirtle usa Pistola Agua!"); }
    @Override public void atacarHidrobomba() { System.out.println("Squirtle usa Hidrobomba!"); }
    @Override public void atacarBurbuja() { System.out.println("Squirtle usa Burbuja!"); }
}
