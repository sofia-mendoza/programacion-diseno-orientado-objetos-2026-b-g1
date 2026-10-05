package pokemones;

import base.Pokemones;
import interfaces.InterfaceLucha;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Machamp extends Pokemones implements InterfaceLucha {
    public Machamp() { super(); }
    public Machamp(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Machamp usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Machamp usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Machamp usa Arañazo."); }

    @Override public void atacarPunoDinamico() { System.out.println("Machamp usa Puño Dinámico!"); }
    @Override public void atacarPatadaSalto() { System.out.println("Machamp usa Patada Salto!"); }
    @Override public void atacarSumision() { System.out.println("Machamp usa Sumisión!"); }
}
