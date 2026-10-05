package pokemones;

import base.Pokemones;
import interfaces.InterfaceRoca;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Graveler extends Pokemones implements InterfaceRoca {
    public Graveler() { super(); }
    public Graveler(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Graveler usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Graveler usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Graveler usa Arañazo."); }

    @Override public void atacarLanzaRocas() { System.out.println("Graveler usa Lanza Rocas!"); }
    @Override public void atacarTumbaRocas() { System.out.println("Graveler usa Tumba Rocas!"); }
    @Override public void atacarRocaAfilada() { System.out.println("Graveler usa Roca Afilada!"); }
}