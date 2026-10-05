package pokemones;

import base.Pokemones;
import interfaces.InterfaceBicho;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Caterpie extends Pokemones implements InterfaceBicho {
    public Caterpie() { super(); }
    public Caterpie(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Caterpie usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Caterpie usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Caterpie usa Arañazo."); }

    @Override public void atacarPinzamiento() { System.out.println("Caterpie usa Pinzamiento!"); }
    @Override public void atacarChupavidas() { System.out.println("Caterpie usa Chupavidas!"); }
    @Override public void atacarPicadura() { System.out.println("Caterpie usa Picadura!"); }
}
