package pokemones;

import base.Pokemones;
import interfaces.InterfaceRoca;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Onix extends Pokemones implements InterfaceRoca {
    public Onix() { super(); }
    public Onix(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Onix usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Onix usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Onix usa Arañazo."); }

    @Override public void atacarLanzaRocas() { System.out.println("Onix usa Lanza Rocas!"); }
    @Override public void atacarTumbaRocas() { System.out.println("Onix usa Tumba Rocas!"); }
    @Override public void atacarRocaAfilada() { System.out.println("Onix usa Roca Afilada!"); }
}
