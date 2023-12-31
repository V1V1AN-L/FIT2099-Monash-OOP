package game.behaviours;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.tools.Status;

/**
 * An Action to attack another Actor.
 * Created by: Riordan D. Alfredo
 *
 * @author Riordan D. Alfredo
 */
public class WanderBehaviour implements Behaviour {
	private static final int WANDER_BEHAVIOUR_PRIORITY = BehaviourPriority.WANDERING.getValue();

	/**
	 * Random value to choose the exit
	 */
	private final Random random = new Random();

	/**
	 * Returns a MoveAction to wander to a random location, if possible.  
	 * If no movement is possible, returns null.
	 * 
	 * @param actor the Actor enacting the behaviour
	 * @param map the map that actor is currently on
	 * @return an Action, or null if no MoveAction is possible
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		if (actor.hasCapability(Status.MOVEMENT_RESTRICTED)){
			return new DoNothingAction();
		}

		ArrayList<Action> actions = new ArrayList<>();
		
		for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
            	actions.add(exit.getDestination().getMoveAction(actor, "around", exit.getHotKey()));
            }
        }

		if (!actions.isEmpty()) {
			return actions.get(random.nextInt(actions.size()));
		}
		else {
			return null; // go to next behaviour
		}
	}

	@Override
	public int getPriority(){
		return WANDER_BEHAVIOUR_PRIORITY;
	}
}
