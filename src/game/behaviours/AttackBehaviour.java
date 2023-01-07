package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.AttackAction;
import game.pokemon.PokemonBase;
import game.tools.Element;
import game.tools.ElementsHelper;
import game.tools.Status;

/**
 * Actor behavior to attack others whenever is possible
 *
 * Created by: Riordan D. Alfredo
 * @author Riordan D. Alfredo
 * Modified by: Jordan Nathanael
 */
public class AttackBehaviour implements Behaviour {
    @Override
    public Action getAction(Actor actor, GameMap map) {
        // check surrounding
        for (Exit exit : map.locationOf(actor).getExits()){
            Location targetLoc = exit.getDestination();
            if (targetLoc.containsAnActor()){
                Actor targetActor = targetLoc.getActor();
                actor.allowableActions(targetActor, targetLoc.toString(), map);

                // if the target is not IMMUNE attack it.
                if (! targetActor.hasCapability(Status.IMMUNE)){
                    // check elements
                    // can attack if actor and target has different element
                    if(! ElementsHelper.hasAnySimilarElements(targetActor, actor.findCapabilitiesByType(Element.class))){
                        //return the action to attack
                        return new AttackAction(targetActor, targetLoc.toString()); // behaviour will stop here.
                    }
                }
            }
        }
        return null; // go to next behaviour
    }
}
