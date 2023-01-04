package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;
import game.pokemon.PokemonBase;
import game.pokemon.Torchic;

import java.util.Random;

public class Crater extends Ground implements SpawnGround {
    private Element element;

    private Location location;

    /**
     * Constructor.
     *
     */
    public Crater() {
        super('C');
        this.element = Element.FIRE;
        addCapability(this.element);
    }
    @Override
    public PokemonBase spawnPokemon() {
        return new Torchic();
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        this.location = location;
        if (Math.random()<=0.1 && !location.containsAnActor()) {
            this.location.addActor(spawnPokemon());
        }
    }
}
