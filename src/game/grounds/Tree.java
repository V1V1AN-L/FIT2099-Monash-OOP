package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.pokemon.Mudkip;
import game.pokemon.PokemonBase;
import game.pokemon.Treecko;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tree extends SpawningGround {

    private List <PokemonBase> TreeckoList = new ArrayList<PokemonBase>();

    /**
     * Constructor.
     *
     */
    public Tree() {
        super('+', Element.GRASS);
    }

    @Override
    public PokemonBase SpawnPokemon(Location location) {
        requiredElementGround = 1;
        if (getSurrounding(location) == requiredElementGround){
            this.spawnedPokemon = new Treecko();
        }
        return this.spawnedPokemon;

    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        int randomNum = new Random().nextInt(99);
        if (randomNum < 15){
            TreeckoList.add(SpawnPokemon(location));
        }
    }
}



