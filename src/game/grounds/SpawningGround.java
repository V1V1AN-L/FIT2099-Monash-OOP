package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.pokemon.PokemonBase;
import game.tools.Element;

import java.util.ArrayList;
import java.util.List;

public abstract class SpawningGround extends Ground {

    protected Element element;

    protected Location location;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public SpawningGround(char displayChar) {
        super(displayChar);
    }

    public abstract PokemonBase spawnPokemon();

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


    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
