package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.pokemon.PokemonBase;

public abstract class GeneralBall extends Item {

    protected PokemonBase storedPokemon;
    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public GeneralBall(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    public PokemonBase getStoredPokemon() {
        return storedPokemon;
    }

    public void setStoredPokemon(PokemonBase storedPokemon) {
        this.storedPokemon = storedPokemon;
    }




}
