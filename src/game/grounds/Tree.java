package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Candy;
import game.tools.Element;
import game.pokemon.PokemonBase;
import game.pokemon.Treecko;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tree extends ConvertibleGrounds implements SpawnGround {
    /**
     * Constructor.
     *
     */
    public Tree() {
        super('+');
        this.element = Element.GRASS;
        addCapability(this.element);
    }

    public int getSurrounding(Location location){
        int counter = 0;
        List<Exit> availableExits = new ArrayList<>(location.getExits());
        for (Exit availableExit : availableExits) {
            if(availableExit.getDestination().getGround().hasCapability(element)){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        this.location = location;
        int requiredElementGround = 1;
        if (Math.random()<=0.15 && getSurrounding(location) == requiredElementGround && !location.containsAnActor()) {
            location.addActor(spawnPokemon());
        }

    }

    @Override
    public void dayEffect() {
        if (Math.random()<=0.95 && this.location != null) {
           location.addItem(new Candy());
        }
    }

    @Override
    public void nightEffect() {
        if(Math.random()<=0.1 && this.location != null){
            if (Math.random()<=0.5){
                expandGround(new Hay());
            }else{
                expandGround(new Tree());
            }
        }
    }

    @Override
    public PokemonBase spawnPokemon() {
        return new Treecko();
    }
}



