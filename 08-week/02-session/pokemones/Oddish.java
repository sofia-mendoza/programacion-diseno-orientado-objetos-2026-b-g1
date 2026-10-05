package pokemones;

import base.Pokemones;
import interfaces.InterfacePlanta;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Oddish extends Pokemones implements InterfacePlanta {
    public Oddish() { super(); }
    public Oddish(int numPokedex, String nombre, double peso, String sexo, int temporada, double altura) {
        super(numPokedex, nombre, peso, sexo, temporada, altura);
    }

    @Override public void atacarPlacaje() { System.out.println("Oddish usa Placaje."); }
    @Override public void atacarMordisco() { System.out.println("Oddish usa Mordisco."); }
    @Override public void atacarAraniazo() { System.out.println("Oddish usa Arañazo."); }

    @Override public void atacarLatigoCepa() { System.out.println("Oddish usa Látigo Cepa!"); }
    @Override public void atacarHojaAfilada() { System.out.println("Oddish usa Hoja Afilada!"); }
    @Override public void atacarRayoSolar() { System.out.println("Oddish usa Rayo Solar!"); }
}
