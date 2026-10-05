package pokemones;

import base.Pokemones;
import interfaces.InterfacePsiquico;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Alakazam extends Pokemones implements InterfacePsiquico {
    public Alakazam() { super(); }
    public Alakazam(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Alakazam usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Alakazam usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Alakazam usa Arañazo."); }

    @Override public void atacarPsiquico() { System.out.println("Alakazam usa Psíquico!"); }
    @Override public void atacarConfusion() { System.out.println("Alakazam usa Confusión!"); }
    @Override public void atacarPsicorrayo() { System.out.println("Alakazam usa Psicorrayo!"); }
}
