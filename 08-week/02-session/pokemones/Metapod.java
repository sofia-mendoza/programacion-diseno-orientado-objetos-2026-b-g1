package pokemones;

import base.Pokemones;
import interfaces.InterfaceBicho;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Metapod extends Pokemones implements InterfaceBicho {
    public Metapod() { super(); }
    public Metapod(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Metapod usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Metapod usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Metapod usa Arañazo."); }

    @Override public void atacarPinzamiento() { System.out.println("Metapod usa Pinzamiento!"); }
    @Override public void atacarChupavidas() { System.out.println("Metapod usa Chupavidas!"); }
    @Override public void atacarPicadura() { System.out.println("Metapod usa Picadura!"); }
}
