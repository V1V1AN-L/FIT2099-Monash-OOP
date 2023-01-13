package game.grounds;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Candy;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.tools.Element;
import game.pokemon.PokemonBase;
import game.pokemon.Treecko;

import java.util.ArrayList;


/**
 * The class instance that represents a Tree ground
 * Capable of expand itself - implements ExpandibleGround.
 * Created by:
 * @author Zecan Liu
 *
 */
public class Tree extends SpawningGround implements ExpandibleGround, TimePerception, DestructibleGround {

    private Location location;

    /**
     * Constructor.
     * Inherit the spawning ground as Tree has the capability of spawning Pokemon
     */
    public Tree() {
        super('T');
        this.element = Element.GRASS;
        addCapability(this.element);
        //Register into the time-managing list
        registerInstance();
    }

    /**
     * The tick method that is operated by the time manager.
     * This allows the ground to update its location if necessary and perform the check and spawning Pokemon
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        this.location = location;
        int requiredElementGround = 1;
        if (Math.random()<=0.15 && getSurrounding(location) >= requiredElementGround && !location.containsAnActor()) {
            location.addActor(spawnPokemon());
        }
    }

    /**
     * The method allowing Tree ground to realise its day effect - dropping candy
     */
    @Override
    public void dayEffect() {
        if (Math.random()<=0.05 && this.location != null) {
           location.addItem(new Candy());
        }
    }

    /**
     * The method allowing Tree ground to implement its night effect for expansion
     * The newly expanded ground from a tree could be either another Tree or Hay
     */
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
    public void midnightEffect() {
        if(this.location!= null && this.location.getItems()!= null){
            for(Item each: new ArrayList<>(this.location.getItems())){
                this.location.removeItem(each);
            }
        }
    }

    @Override
    public void duskEffect() {
        if (Math.random()<=0.1 && this.location != null)  {
            destroyGround(this.location);
            TimePerceptionManager.getInstance().cleanUp(this);
        }
    }

    /**
     * Spawning a new pokemon
     * @return Treecko - a new pokemon instance
     */
    @Override
    protected PokemonBase spawnPokemon() {
        return new Treecko();
    }

}



