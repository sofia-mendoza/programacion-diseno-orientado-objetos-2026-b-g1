package pokemones;

import base.Pokemones;
import interfaces.InterfacePsiquico;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Kadabra extends Pokemones implements InterfacePsiquico {
    public Kadabra() { super(); }
    public Kadabra(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Kadabra usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Kadabra usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Kadabra usa Arañazo."); }

    @Override public void atacarPsiquico() { System.out.println("Kadabra usa Psíquico!"); }
    @Override public void atacarConfusion() { System.out.println("Kadabra usa Confusión!"); }
    @Override public void atacarPsicorrayo() { System.out.println("Kadabra usa Psicorrayo!"); }
}
