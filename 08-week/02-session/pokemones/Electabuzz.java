package pokemones;

import base.Pokemones;
import interfaces.InterfaceElectrico;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Electabuzz extends Pokemones implements InterfaceElectrico {
    public Electabuzz() { super(); }
    public Electabuzz(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Electabuzz usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Electabuzz usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Electabuzz usa Arañazo."); }

    @Override public void atacarImpactrueno() { System.out.println("Electabuzz usa Impactrueno!"); }
    @Override public void atacarRayo() { System.out.println("Electabuzz usa Rayo!"); }
    @Override public void atacarChispazo() { System.out.println("Electabuzz usa Chispazo!"); }
}
