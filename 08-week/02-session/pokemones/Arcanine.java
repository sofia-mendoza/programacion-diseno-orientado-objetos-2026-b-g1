package pokemones;

import base.Pokemones;
import interfaces.InterfaceFuego;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Arcanine extends Pokemones implements InterfaceFuego {
    public Arcanine() { super(); }
    public Arcanine(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Arcanine usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Arcanine usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Arcanine usa Arañazo."); }

    @Override public void atacarLanzallamas() { System.out.println("Arcanine usa Lanzallamas!"); }
    @Override public void atacarAscuas() { System.out.println("Arcanine usa Ascuas!"); }
    @Override public void atacarGiroFuego() { System.out.println("Arcanine usa Giro Fuego!"); }
}
