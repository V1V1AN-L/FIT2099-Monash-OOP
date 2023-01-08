package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.tools.Status;
/**
 * The class instance that represents a Wall ground
 * Created by:
 * @author Zecan Liu
 *
 */
public class Wall extends Ground {

	/**
	 * Constructor.
	 * Inherit the Ground abstract class
	 * Defining the display character
	 */
	public Wall() {
		super('#');
	}

	/**
	 * The method realising the characteristic of a wall ground -  not allowing one to entre
	 * @param actor the Actor to check
	 * @return boolean for checking if one could enter this ground
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}

	/**
	 * This method basically blocks one from throwing on to the wall as returning true all the time
	 * @return boolean for checking if one could throw object on the wall
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

	/**
	 * Method allowing adding capability to the ground instance.
	 * @param capability the Capability to add
	 */
	@Override
	public void addCapability(Enum<?> capability) {
		super.addCapability(capability);
		addCapability(Status.NONCONVERTIBLE);

	}
}
