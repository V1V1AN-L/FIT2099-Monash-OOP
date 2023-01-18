package game.grounds;


import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;
import game.pokemon.Mudkip;
import game.pokemon.PokemonBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * The class instance that represents a Waterfall ground
 * Created by:
 * @author Zecan Liu
 *
 */
public class Waterfall extends SpawningGround {

    /**
     * Constructor.
     * Inherit the SpawningGround abstract class - Waterfall could spawn pokemon
     */
    public Waterfall() {
        super('W');
        this.element = Element.WATER;
        addCapability(this.element);
    }

    /**
     * The method allowing the spawning of Pokemon. This is run as the tick method operated by the time manager.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
//        super.tick(location);
//        this.location = location;
        int requiredElementGround = 2;
        if (Math.random()<=0.2 && getSurrounding(location) >= requiredElementGround && !location.containsAnActor()) {
            location.addActor(spawnPokemon());
        }
    }

    /**
     * Method spawning the pokemon
     * @return Mukip -  the new Pokemon instacne.
     */
    @Override
    protected PokemonBase spawnPokemon() {
        return new Mudkip();
    }
}
