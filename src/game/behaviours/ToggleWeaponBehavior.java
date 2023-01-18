package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.pokemon.PokemonBase;
import game.tools.Element;
import game.tools.ElementsHelper;

/**
 * Check the element of current ground the pokemon is standing on:
 *  if it has the same element wiht the pokemon, toggle the weapon
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public class ToggleWeaponBehavior implements Behaviour {
    public static final int TOGGLE_BEHAVIOUR_PRIORITY = BehaviourPriority.TOGGLING.getValue();

    /**
     * The pokemon that will toggle the weapon
     */
    PokemonBase pokemon;

    /**
     * Constructor.
     *
     * @param pokemon the pokemon that will toggle the weapon
     */
    public ToggleWeaponBehavior(PokemonBase pokemon){
        this.pokemon = pokemon;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        // check the actor ground that it is standing on.
        boolean conditionMet = ElementsHelper.hasAnySimilarElements(map.locationOf(actor).getGround(), actor.findCapabilitiesByType(Element.class));

        pokemon.toggleWeapon(conditionMet, actor, map);

        return null; // go to next behavior
    }

    @Override
    public int getPriority(){
        return TOGGLE_BEHAVIOUR_PRIORITY;
    }
}
