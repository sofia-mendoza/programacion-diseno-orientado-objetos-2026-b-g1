package pokemones;

import base.Pokemones;
import interfaces.InterfaceElectrico;

/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Pikachu extends Pokemones implements InterfaceElectrico {
    public Pikachu() { super(); }
    public Pikachu(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Pikachu usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Pikachu usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Pikachu usa Arañazo."); }

    @Override public void atacarImpactrueno() { System.out.println("Pikachu usa Impactrueno!"); }
    @Override public void atacarRayo() { System.out.println("Pikachu usa Rayo!"); }
    @Override public void atacarChispazo() { System.out.println("Pikachu usa Chispazo!"); }
}
