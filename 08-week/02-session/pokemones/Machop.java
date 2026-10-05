package pokemones;

import base.Pokemones;
import interfaces.InterfaceLucha;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Machop extends Pokemones implements InterfaceLucha {
    public Machop() { super(); }
    public Machop(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Machop usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Machop usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Machop usa Arañazo."); }

    @Override public void atacarPunoDinamico() { System.out.println("Machop usa Puño Dinámico!"); }
    @Override public void atacarPatadaSalto() { System.out.println("Machop usa Patada Salto!"); }
    @Override public void atacarSumision() { System.out.println("Machop usa Sumisión!"); }
}
