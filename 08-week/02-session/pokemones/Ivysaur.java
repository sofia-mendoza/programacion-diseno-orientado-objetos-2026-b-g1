package pokemones;

import base.Pokemones;
import interfaces.InterfacePlanta;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Ivysaur extends Pokemones implements InterfacePlanta {
    public Ivysaur() { super(); }
    public Ivysaur(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Ivysaur usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Ivysaur usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Ivysaur usa Arañazo."); }

    @Override public void atacarLatigoCepa() { System.out.println("Ivysaur usa Látigo Cepa!"); }
    @Override public void atacarHojaAfilada() { System.out.println("Ivysaur usa Hoja Afilada!"); }
    @Override public void atacarRayoSolar() { System.out.println("Ivysaur usa Rayo Solar!"); }
}
