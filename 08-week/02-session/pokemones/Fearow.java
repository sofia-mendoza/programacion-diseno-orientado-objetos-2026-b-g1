package pokemones;

import base.Pokemones;
import interfaces.InterfaceVolador;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Fearow extends Pokemones implements InterfaceVolador {
    public Fearow() { super(); }
    public Fearow(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Fearow usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Fearow usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Fearow usa Arañazo."); }

    @Override public void atacarAtaqueAla() { System.out.println("Fearow usa Ataque Ala!"); }
    @Override public void atacarTornado() { System.out.println("Fearow usa Tornado!"); }
    @Override public void atacarPicoTaladro() { System.out.println("Fearow usa Pico Taladro!"); }
}
