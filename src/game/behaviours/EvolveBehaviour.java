package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.EvolveAction;
import game.pokemon.EvolvedPokemonBase;
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
        if ((TimePerceptionManager.getInstance().getTurn() - pokemon.getExistTurn()) >= EVOLVE_TURN){
            //stay live for 5 turn
            // no one near the pokemon
            Actor nearbyActor = null;
            for (Exit exit : map.locationOf(actor).getExits()) {
                nearbyActor = exit.getDestination().getActor();
                if (nearbyActor != null){
                    break;
                }
            }

            // only itself, do evolution
            if (nearbyActor == null) {
                return new EvolveAction(pokemon, "here");
            }
        }

        return null;
    }

    @Override
    public int getPriority(){
        return EVOLVE_BEHAVIOUR_PRIORITY;
    }
}
