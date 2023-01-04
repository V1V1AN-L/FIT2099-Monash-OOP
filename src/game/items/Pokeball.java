package game.items;

import game.Player;

public class Pokeball extends GeneralBall{
    /***
     * Constructor.

     */
    public Pokeball() {
        super("Pokeball", 'o', true);

        Player.pokeballsBag.add(this);
    }

    public String toString() {
        return "Pokeball";
    }
}
