package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;
import game.pokemon.PokemonBase;
import game.pokemon.Torchic;


/**
 * The ground instance representing a crater.
 * Element: Fire.
 * Spawn Pokemon: Torchic
 */

public class Crater extends SpawningGround {
    /**
     * Constructor.
     * Inherit from the SpawningGround Abstract Class
     * Set element
     */
    public Crater() {
        super('C');
        this.element = Element.FIRE;
        addCapability(this.element);
    }

    /**
     * Getter
     *
     * @return Torchic - Spawned Pokemon
     */
    @Override
    protected PokemonBase spawnPokemon() {
        return new Torchic();
    }

    /**
     * The time ticking function. For each game turn perform the random check for spawning Pokemon
     * Set the Pokemon to the current location - activate the Pokemon to the game world
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (Math.random()<=0.1 && !location.containsAnActor()) {
            location.addActor(spawnPokemon());
        }
    }
}
