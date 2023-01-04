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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class AttackBehaviour implements Behaviour {
    /**
     *  HINT: develop a logic to check surrounding, check elements, and return an action to attack that opponent.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        // check surrounding
        Location targetLoc = null;
        List<Actor> targetActor = new ArrayList<Actor>();

        for (Exit exit : map.locationOf(actor).getExits()){
            targetLoc = exit.getDestination();
            if (targetLoc.containsAnActor()){
                int index = 0;
                targetActor.add(targetLoc.getActor());
                actor.allowableActions(targetActor.get(index), targetLoc.toString(), map);
                index += 1;
            }
        }

        System.out.println(targetActor);

        if (targetActor != null){
            // check target is IMMUNE or not
            for (Actor target : targetActor){
                if (target.hasCapability(Status.IMMUNE)){
                    return null;
                }

                // check elements
                // can attack if actor and target has different element
                if(! ElementsHelper.hasAnySimilarElements(target, actor.findCapabilitiesByType(Element.class))){
                    // if pokemon wants to attack, check the ground first, and then create the special Weapon
                    Location steppedGround = map.locationOf(actor);

                    if(ElementsHelper.hasAnySimilarElements(steppedGround.getGround(), actor.findCapabilitiesByType(Element.class))){
                        ((PokemonBase) actor).toggleWeapon(false);
                    }

                    //return the action to attack
                    return new AttackAction(target, targetLoc.toString()); // behaviour will stop here.
                }
            }

        }
        return null; // go to next behaviour
    }
}
