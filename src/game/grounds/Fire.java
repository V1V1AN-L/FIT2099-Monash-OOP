package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.pokemon.PokemonBase;
import game.tools.Element;
import game.tools.Status;
import java.util.List;


/**
 * A class that represents the fire
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public class Fire extends Ground {
    /**
     * Constructor
     * Inherit from Ground.
     * Set the display character to 'v'
     */
    public Fire() {
        super('v');
    }

    /**
     * Set/add capability method
     * @param capability the Capability to add
     */
    @Override
    public void addCapability(Enum<?> capability) {
        super.addCapability(capability);
        addCapability(Element.FIRE);
    }
}