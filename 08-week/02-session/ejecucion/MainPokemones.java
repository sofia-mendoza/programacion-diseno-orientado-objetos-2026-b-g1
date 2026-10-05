package ejecucion;

import pokemones.Pikachu;
import pokemones.Charmander;
import pokemones.Squirtle;
/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class MainPokemones {
    public static void main(String[] args) {

        Pikachu pikachu = new Pikachu(25, "Pikachu", 6.0, "M", 1, 0.4);
        Charmander charmander = new Charmander(4, "Charmander", 8.5, "M", 1, 0.6);
        Squirtle squirtle = new Squirtle(7, "Squirtle", 9.0, "M", 1, 0.5);

        System.out.println("=== DEMOSTRACIÓN CÓDIGO POKÉMON ===");

        System.out.println("\n--- PIKACHU ---");
        pikachu.atacarPlacaje();
        pikachu.atacarImpactrueno();

        System.out.println("\n--- CHARMANDER ---");
        charmander.atacarAraniazo();
        charmander.atacarLanzallamas();

        System.out.println("\n--- SQUIRTLE ---");
        squirtle.atacarMordisco();
        squirtle.atacarPistolaAgua();
    }
}