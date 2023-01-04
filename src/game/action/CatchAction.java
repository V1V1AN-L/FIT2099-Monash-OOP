package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.affection.AffectionManager;
import game.items.GeneralBall;
import game.items.Pokeball;
import game.pokemon.PokemonBase;
import game.tools.Status;

public class CatchAction extends Action {
    private Actor captured;
    private String direction;

    public CatchAction(Actor captured, String direction){
        this.captured = captured;
        this.direction = direction;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " captured " + captured.toString();
        boolean capturable = false;

        if (captured.hasCapability(Status.UNCATCHABLE)){
            return result + " is failed because the pokemon can't be catch by any chance.";
        }

        // FIXME related with the pokeball etc
        // get the pokeball first either pokeball or GreatBall or MasterBall
        // assume always using pokeball
        GeneralBall pokeball = new Pokeball();


        // check AP first
        AffectionManager am = AffectionManager.getInstance();
        int affectionPoint = am.getAffectionPoint(((PokemonBase) captured));

        // FIXME update the ball req
        if (affectionPoint > 20){
            // save the pokemon into the GeneralBall
            pokeball.setStoredPokemon(((PokemonBase) captured));

            // Add the filledPokeball into inventory
            actor.addItemToInventory(pokeball);

            // delete the captured pokemon from the map
            map.removeActor(captured);

            result += " is successful";
            return result;
        }
        // if capturingAction is failed, decrease AP by 10
        am.decreaseAffection(captured, 10);

        result += " is failed";
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " captures " + captured.toString() + " at " + direction;
    }
}
