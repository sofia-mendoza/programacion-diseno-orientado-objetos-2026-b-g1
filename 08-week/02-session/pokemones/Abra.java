package pokemones;

import base.Pokemones;
import interfaces.InterfacePsiquico;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Abra extends Pokemones implements InterfacePsiquico {
    public Abra() { super(); }
    public Abra(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Abra usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Abra usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Abra usa Arañazo."); }

    @Override public void atacarPsiquico() { System.out.println("Abra usa Psíquico!"); }
    @Override public void atacarConfusion() { System.out.println("Abra usa Confusión!"); }
    @Override public void atacarPsicorrayo() { System.out.println("Abra usa Psicorrayo!"); }
}
