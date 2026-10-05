package pokemones;

import base.Pokemones;
import interfaces.InterfaceFuego;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Charmander extends Pokemones implements InterfaceFuego {
    public Charmander() { super(); }
    public Charmander(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Charmander usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Charmander usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Charmander usa Arañazo."); }

    @Override public void atacarLanzallamas() { System.out.println("Charmander usa Lanzallamas!"); }
    @Override public void atacarAscuas() { System.out.println("Charmander usa Ascuas!"); }
    @Override public void atacarGiroFuego() { System.out.println("Charmander usa Giro Fuego!"); }
}
