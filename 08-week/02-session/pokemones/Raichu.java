package pokemones;

import base.Pokemones;
import interfaces.InterfaceElectrico;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Raichu extends Pokemones implements InterfaceElectrico {
    public Raichu() { super(); }
    public Raichu(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Raichu usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Raichu usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Raichu usa Arañazo."); }

    @Override public void atacarImpactrueno() { System.out.println("Raichu usa Impactrueno!"); }
    @Override public void atacarRayo() { System.out.println("Raichu usa Rayo!"); }
    @Override public void atacarChispazo() { System.out.println("Raichu usa Chispazo!"); }
}