package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.pokemon.PokemonBase;
import game.tools.Element;

import java.util.ArrayList;
import java.util.List;
/**
 * The abstract class instance that defines the ground instances that could spawn Pokemon
 * Capable of expand/destroy itself - implements Destructible-/Expandible-Ground.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * Zecan Liu
 *
 */
public abstract class SpawningGround extends Ground {

    protected Element element;

    /**
     * Constructor. Inherit from the Ground abstract class
     * @param displayChar character to display for this type of terrain
     */
    public SpawningGround(char displayChar) {
        super(displayChar);

    }

    /**
     * The abstract method that requires all child classes to implement/realise spawning Pokemon
     */
    protected abstract PokemonBase spawnPokemon();

    /**
     * The method allowing the spawning ground to count the same-element ground in its surrounding
     * @param location - the location of the current ground
     * @return - the count for number of same-element ground in the neighbouring the current ground
     * This is used for the spawning action of the waterfall
     */
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

    /**
     * Getter
     * @return element
     */
    public Element getElement() {
        return element;
    }

    /**
     * Setter
     * @param element - the element set to the ground instance
     */
    public void setElement(Element element) {
        this.element = element;
    }




}
