package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.items.Candy;
import game.time.TimePerception;
import game.tools.Element;
import game.pokemon.PokemonBase;
import game.pokemon.Treecko;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tree extends SpawningGround implements ExpandibleGround, TimePerception {

    private Location location;

    /**
     * Constructor.
     *
     */
    public Tree() {
        super('T');
        this.element = Element.GRASS;
        addCapability(this.element);
        registerInstance();
    }


    @Override
    public void tick(Location location) {
//        super.tick(location);
        this.location = location;
        int requiredElementGround = 1;
        if (Math.random()<=0.15 && getSurrounding(location) >= requiredElementGround && !location.containsAnActor()) {
            location.addActor(spawnPokemon());
        }

    }

    @Override
    public void dayEffect() {
        if (Math.random()<=0.05 && this.location != null) {
           location.addItem(new Candy());
        }
    }

    @Override
    public void nightEffect() {
        if(Math.random()<=0.1 && this.location != null){
            if (Math.random()<=0.5){
                expandGround(this.location, new Hay(),Element.GRASS);
            }else{
                expandGround(this.location, new Tree(), Element.GRASS);
            }
        }
    }

    @Override
    public PokemonBase spawnPokemon() {
        return new Treecko();
    }

}



