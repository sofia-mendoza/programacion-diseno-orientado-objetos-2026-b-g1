package pokemones;

import base.Pokemones;
import interfaces.InterfaceVeneno;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Arbok extends Pokemones implements InterfaceVeneno {
    public Arbok() { super(); }
    public Arbok(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Arbok usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Arbok usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Arbok usa Arañazo."); }

    @Override public void atacarPunoVeneno() { System.out.println("Arbok usa Puño Veneno!"); }
    @Override public void atacarBombaLodo() { System.out.println("Arbok usa Bomba Lodo!"); }
    @Override public void atacarAcido() { System.out.println("Arbok usa Ácido!"); }
}
