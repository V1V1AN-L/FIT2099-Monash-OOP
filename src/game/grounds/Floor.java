package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.pokemon.PokemonBase;
import game.tools.Status;
import java.util.List;


/**
 * A class that represents the floor inside a building.
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * Zecan Liu
 */
public class Floor extends Ground {
	/**
	 * Constructor
	 * Inherit from Ground.
	 * Set the display character to '_'
	 */
	public Floor() {
		super('_');
	}

	/**
	 * Check method to see if an actor instance could entre the floor
	 * @param actor the Actor instance to check
	 * @return boolean - true or false.
	 *
	 * Only return true is the actor is not a Pokemon (only player allowed)
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor.hasCapability(Status.ENTERABLE)){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Set/add capability method
	 * @param capability the Capability to add
	 */
	@Override
	public void addCapability(Enum<?> capability) {
		super.addCapability(capability);
		addCapability(Status.NONCONVERTIBLE);

	}

}
