package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;
import game.pokemon.Mudkip;
import game.pokemon.PokemonBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Waterfall extends SpawningGround{

//    private List<PokemonBase> MudkipList = new ArrayList<PokemonBase>();

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     * @param element
     */
    public Waterfall(char displayChar, Element element) {
        super('W', Element.WATER);
    }

//    public List<PokemonBase> getMudkipList() {
//        return MudkipList;
//    }
//
//    public void setMudkipList(List<PokemonBase> mudkipList) {
//        MudkipList = mudkipList;
//    }

    @Override
    public PokemonBase SpawnPokemon(Location location) {
        requiredElementGround = 2;
        if (getSurrounding(location) == requiredElementGround){
            this.spawnedPokemon = new Mudkip();
        }
        return this.spawnedPokemon;
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        int randomNum = new Random().nextInt(9);
        if (randomNum < 2){
           location.addActor(SpawnPokemon(location));
        }
    }
}
