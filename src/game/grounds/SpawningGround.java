package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;
import game.pokemon.PokemonBase;

import java.util.ArrayList;
import java.util.List;

public abstract class SpawningGround extends Ground {

    protected Element element;
    protected PokemonBase spawnedPokemon;

    protected int requiredElementGround;

    protected int counter;


    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     * @param element
     */
    public SpawningGround(char displayChar, Element element) {
        super(displayChar);
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public PokemonBase getSpawnedPokemon() {
        return spawnedPokemon;
    }

    public void setSpawnedPokemon(PokemonBase spawnedPokemon) {
        this.spawnedPokemon = spawnedPokemon;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     *
     * @param location
     * @return the number of same element grounds in surrounding
     */
    public int getSurrounding(Location location){
        this.counter = 0;

        List<Exit> availableExits = new ArrayList<>(location.getExits());
        for (Exit availableExit : availableExits) {
            if(availableExit.getDestination().getGround().hasCapability(element)){
                this.counter++;
            }
        }
        return this.counter;
    }

    public abstract PokemonBase SpawnPokemon(Location location);







}
