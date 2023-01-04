package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.pokemon.PokemonBase;
import game.time.TimePerception;
import game.tools.Element;

import java.util.Random;

public class Puddle extends Ground implements DestructibleGround, ExpandibleGround, TimePerception {
    /**
     * Constructor.
     *
     */

    private Element element;

    private Location location;

    public Puddle() {
        super('~');
        this.element = Element.WATER;
        addCapability(this.element);
        registerInstance();
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        this.location = location;
    }

    @Override
    public void dayEffect() {
        if (Math.random()<=0.1 && this.location != null)  {
            destroyGround(this.location);
        }
    }

    @Override
    public void nightEffect() {
        if(Math.random()<=0.1 && this.location != null){
            expandGround(this.location, new Puddle(), Element.WATER);
        }
    }

}
