package pokemones;

import base.Pokemones;
import interfaces.InterfaceAgua;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Blastoise extends Pokemones implements InterfaceAgua {
    public Blastoise() { super(); }
    public Blastoise(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Blastoise usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Blastoise usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Blastoise usa Arañazo."); }

    @Override public void atacarPistolaAgua() { System.out.println("Blastoise usa Pistola Agua!"); }
    @Override public void atacarHidrobomba() { System.out.println("Blastoise usa Hidrobomba!"); }
    @Override public void atacarBurbuja() { System.out.println("Blastoise usa Burbuja!"); }
}
