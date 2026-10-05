package pokemones;

import base.Pokemones;
import interfaces.InterfaceRoca;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Geodude extends Pokemones implements InterfaceRoca {
    public Geodude() { super(); }
    public Geodude(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Geodude usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Geodude usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Geodude usa Arañazo."); }

    @Override public void atacarLanzaRocas() { System.out.println("Geodude usa Lanza Rocas!"); }
    @Override public void atacarTumbaRocas() { System.out.println("Geodude usa Tumba Rocas!"); }
    @Override public void atacarRocaAfilada() { System.out.println("Geodude usa Roca Afilada!"); }
}
