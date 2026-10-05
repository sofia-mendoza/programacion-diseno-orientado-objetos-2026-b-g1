package pokemones;

import base.Pokemones;
import interfaces.InterfaceLucha;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Machoke extends Pokemones implements InterfaceLucha {
    public Machoke() { super(); }
    public Machoke(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Machoke usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Machoke usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Machoke usa Arañazo."); }

    @Override public void atacarPunoDinamico() { System.out.println("Machoke usa Puño Dinámico!"); }
    @Override public void atacarPatadaSalto() { System.out.println("Machoke usa Patada Salto!"); }
    @Override public void atacarSumision() { System.out.println("Machoke usa Sumisión!"); }
}
