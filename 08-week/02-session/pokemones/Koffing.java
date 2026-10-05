package pokemones;

import base.Pokemones;
import interfaces.InterfaceVeneno;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Koffing extends Pokemones implements InterfaceVeneno {
    public Koffing() { super(); }
    public Koffing(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Koffing usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Koffing usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Koffing usa Arañazo."); }

    @Override public void atacarPunoVeneno() { System.out.println("Koffing usa Puño Veneno!"); }
    @Override public void atacarBombaLodo() { System.out.println("Koffing usa Bomba Lodo!"); }
    @Override public void atacarAcido() { System.out.println("Koffing usa Ácido!"); }
}
