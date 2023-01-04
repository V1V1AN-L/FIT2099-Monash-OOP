package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.pokemon.PokemonBase;

public class SummonAction extends Action {
    /**
     * The actor that want to be summoned
     */
    private Actor summoned;
    private Location summonLoc;

    public SummonAction(Actor summoned){
        this.summoned = summoned;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " summoned " + summoned.toString();
        // check surrounding to get the position to summon the pokemon
        for (Exit exit : map.locationOf(actor).getExits()){
            summonLoc = exit.getDestination();
            if (summonLoc.canActorEnter(actor)){
                map.addActor(summoned, summonLoc);
                result += " is successful.";
                return result;
            }
        }
        result += " is failed because there isn't any available space to summon the pokemon.";
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " summons " + summoned;
    }
}
