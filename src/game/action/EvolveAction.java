package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.affection.AffectionManager;
import game.pokemon.EvolvedPokemonBase;
import game.pokemon.PokemonBase;

/**
 * An Action to attack another Actor.
 * Created by: Riordan D. Alfredo
 *
 * @author Riordan D. Alfredo
 * Modified by: Jordan Nathanael
 */
public class EvolveAction extends Action {

    /**
     * The Actor that wants to evolve
     */
    protected EvolvedPokemonBase target;

    /**
     * The direction of incoming evolve manual
     */
    protected String direction;


    /**
     * Constructor.
     *
     * @param target the Actor to attack
     * @param direction the direction of incoming attack
     */
    public EvolveAction(EvolvedPokemonBase target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Execute the attack Action: search weapon, decrease the opponent hp, remove opponent if it is unconscious
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        PokemonBase evolvedPokemon = target.evolve();

        // use this affectionPoint for modify the evolved version
        // if its original AP is 10, so after it evolves itself, its ap also becomes 10
        int affectionPoint = AffectionManager.getInstance().getAffectionPoint(target);

        AffectionManager.getInstance().unregisterPokemon(target);
        AffectionManager.getInstance().modifyAffection(evolvedPokemon, affectionPoint);

        //replace the old pokemon with the evolved in the map
        Location evolutionLoc = map.locationOf(target);
        map.removeActor(target);
        map.addActor(evolvedPokemon, evolutionLoc);

        return "Evolution is successful. " + target + " evolves into " + evolvedPokemon;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " helps " + target + " at " + direction + " to evolve.";
    }
}
