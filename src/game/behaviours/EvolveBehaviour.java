package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.EvolveAction;
import game.affection.AffectionManager;
import game.pokemon.EvolvedPokemonBase;
import game.pokemon.PokemonBase;
import game.time.TimePerceptionManager;

/**
 * Evolve itself after certain number of turns
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public class EvolveBehaviour implements Behaviour {
    public static final int EVOLVE_BEHAVIOUR_PRIORITY = BehaviourPriority.TOGGLING.getValue();
    public static final int EVOLVE_TURN = 5;

    /**
     * The pokemon that will evolve
     */
    EvolvedPokemonBase pokemon;

    /**
     * Constructor.
     *
     * @param pokemon the pokemon that will evolve
     */
    public EvolveBehaviour(EvolvedPokemonBase pokemon){
        this.pokemon = pokemon;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        // FIXME this turn is overall turn, not turn specific to each pokemon lives
        if (TimePerceptionManager.getInstance().getTurn() % EVOLVE_TURN == EVOLVE_TURN-1){
            //stay live for 5 turn
            // no one near the pokemon
            Location nearbyActor = map.locationOf(actor);
            for (Exit exit : map.locationOf(actor).getExits()) {
                nearbyActor = exit.getDestination();
            }

            // only itself, do evolution
            if (nearbyActor.getActor() == actor) {
                new EvolveAction(pokemon, "here").execute(pokemon, map);
            }
        }

        return null;
    }

    @Override
    public int getPriority(){
        return EVOLVE_BEHAVIOUR_PRIORITY;
    }
}
