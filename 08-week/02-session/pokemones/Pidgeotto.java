package pokemones;

import base.Pokemones;
import interfaces.InterfaceVolador;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Pidgeotto extends Pokemones implements InterfaceVolador {
    public Pidgeotto() { super(); }
    public Pidgeotto(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Pidgeotto usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Pidgeotto usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Pidgeotto usa Arañazo."); }

    @Override public void atacarAtaqueAla() { System.out.println("Pidgeotto usa Ataque Ala!"); }
    @Override public void atacarTornado() { System.out.println("Pidgeotto usa Tornado!"); }
    @Override public void atacarPicoTaladro() { System.out.println("Pidgeotto usa Pico Taladro!"); }
}
