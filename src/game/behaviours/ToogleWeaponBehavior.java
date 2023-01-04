package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.pokemon.PokemonBase;
import game.tools.Element;
import game.tools.ElementsHelper;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * Check the element of current ground the pokemon is standing on
 */
public class ToogleWeaponBehavior implements Behaviour {
    PokemonBase pokemon;

    public ToogleWeaponBehavior(PokemonBase pokemon){
        this.pokemon = pokemon;
    }

    // getAction can't have dependency on PokemonBase bcs we implements Behavior
    @Override
    public Action getAction(Actor actor, GameMap map) {
        // check the actor ground that it is standing on.
        boolean conditionMet = ElementsHelper.hasAnySimilarElements(map.locationOf(actor).getGround(), actor.findCapabilitiesByType(Element.class));

        // check toogleWeapon method.
        // FIXME edit this casting
        pokemon.toggleWeapon(conditionMet);

        return null; // go to next behavior
    }
}
