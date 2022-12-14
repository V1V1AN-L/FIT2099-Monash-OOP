package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.pokemon.PokemonBase;
import game.pokemon.Torchic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Crater extends SpawningGround{


    private List<PokemonBase> TorchicList = new ArrayList<PokemonBase>();
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     * @param element
     */
    public Crater(char displayChar, Element element) {
        super('C', Element.FIRE);
    }

    public List<PokemonBase> getTorchicList() {
        return TorchicList;
    }

    public void setTorchicList(List<PokemonBase> torchicList) {
        TorchicList = torchicList;
    }

    @Override
    public PokemonBase SpawnPokemon(Location location) {
        this.spawnedPokemon = new Torchic();
        return this.spawnedPokemon;
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        int randomNum = new Random().nextInt(9);
        if (randomNum == 0){
            TorchicList.add(SpawnPokemon(location));
        }
    }
}
