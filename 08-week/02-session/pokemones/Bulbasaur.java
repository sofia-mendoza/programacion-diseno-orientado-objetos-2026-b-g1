package pokemones;

import base.Pokemones;
import interfaces.InterfacePlanta;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Bulbasaur extends Pokemones implements InterfacePlanta {
    public Bulbasaur() { super(); }
    public Bulbasaur(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Bulbasaur usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Bulbasaur usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Bulbasaur usa Arañazo."); }

    @Override public void atacarLatigoCepa() { System.out.println("Bulbasaur usa Látigo Cepa!"); }
    @Override public void atacarHojaAfilada() { System.out.println("Bulbasaur usa Hoja Afilada!"); }
    @Override public void atacarRayoSolar() { System.out.println("Bulbasaur usa Rayo Solar!"); }
}
