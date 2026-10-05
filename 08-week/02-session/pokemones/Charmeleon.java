package pokemones;

import base.Pokemones;
import interfaces.InterfaceFuego;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Charmeleon extends Pokemones implements InterfaceFuego {
    public Charmeleon() { super(); }
    public Charmeleon(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Charmeleon usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Charmeleon usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Charmeleon usa Arañazo."); }

    @Override public void atacarLanzallamas() { System.out.println("Charmeleon usa Lanzallamas!"); }
    @Override public void atacarAscuas() { System.out.println("Charmeleon usa Ascuas!"); }
    @Override public void atacarGiroFuego() { System.out.println("Charmeleon usa Giro Fuego!"); }
}
