package pokemones;

import base.Pokemones;
import interfaces.InterfaceVeneno;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Ekans extends Pokemones implements InterfaceVeneno {
    public Ekans() { super(); }
    public Ekans(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Ekans usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Ekans usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Ekans usa Arañazo."); }

    @Override public void atacarPunoVeneno() { System.out.println("Ekans usa Puño Veneno!"); }
    @Override public void atacarBombaLodo() { System.out.println("Ekans usa Bomba Lodo!"); }
    @Override public void atacarAcido() { System.out.println("Ekans usa Ácido!"); }
}
