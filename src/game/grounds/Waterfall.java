package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;
import game.pokemon.Mudkip;
import game.pokemon.PokemonBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Waterfall extends SpawningGround {

    /**
     * Constructor.
     *
     */
    public Waterfall() {
        super('W');
        this.element = Element.WATER;
        addCapability(this.element);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        this.location = location;
        int requiredElementGround = 2;
        if (Math.random()<=0.2 && getSurrounding(location) == requiredElementGround && !location.containsAnActor()) {
            location.addActor(spawnPokemon());
        }
    }

    @Override
    public PokemonBase spawnPokemon() {
        return new Mudkip();
    }
}
