package pokemones;

import base.Pokemones;
import interfaces.InterfaceVolador;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Pidgey extends Pokemones implements InterfaceVolador {
    public Pidgey() { super(); }
    public Pidgey(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Pidgey usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Pidgey usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Pidgey usa Arañazo."); }

    @Override public void atacarAtaqueAla() { System.out.println("Pidgey usa Ataque Ala!"); }
    @Override public void atacarTornado() { System.out.println("Pidgey usa Tornado!"); }
    @Override public void atacarPicoTaladro() { System.out.println("Pidgey usa Pico Taladro!"); }
}
