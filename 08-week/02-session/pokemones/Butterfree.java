package pokemones;

import base.Pokemones;
import interfaces.InterfaceBicho;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Butterfree extends Pokemones implements InterfaceBicho {
    public Butterfree() { super(); }
    public Butterfree(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Butterfree usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Butterfree usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Butterfree usa Arañazo."); }

    @Override public void atacarPinzamiento() { System.out.println("Butterfree usa Pinzamiento!"); }
    @Override public void atacarChupavidas() { System.out.println("Butterfree usa Chupavidas!"); }
    @Override public void atacarPicadura() { System.out.println("Butterfree usa Picadura!"); }
}
