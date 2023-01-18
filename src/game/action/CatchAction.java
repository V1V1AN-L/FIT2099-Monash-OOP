package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.affection.AffectionManager;
import game.items.*;
import game.items.Ball.GeneralBall;
import game.pokemon.PokemonBase;

/**
 * An abstract action to catch another PokemonBase
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class CatchAction extends Action {
    /**
     * Fixed value to decrease the affection point if catch action si failed
     */
    public static final int UNSUCCESSFUL_CATCHING = 10;

    /**
     * the actor that is to be catched
     */
    private Actor captured;

    /**
     * the direction of incoming catch
     */
    private String direction;

    /**
     * the target pokemon will be stored inside this ball
     */
    private GeneralBall ball;

    /**
     * Constructor.
     *
     * @param captured actpr that will be captured
     * @param direction the direction of incoming catch
     * @param ball the target pokemon will be stored inside this ball
     */
    public CatchAction(Actor captured, String direction, GeneralBall ball){
        this.captured = captured;
        this.direction = direction;
        this.ball = ball;
    }

    /**
     *Catch the action execution
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return message whether catchAction is success or fail
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // check AP first
        PokemonBase pokemon = AffectionManager.getInstance().findPokemon(captured);
        int affectionPoint = AffectionManager.getInstance().getAffectionPoint(pokemon);
        try {
            if (this.ball.checkAffectionPointReq(pokemon, affectionPoint)) {
                return capturing(actor, map);
            }
        } catch(Exception e) {
            return e.getMessage();
        }
        // if capturingAction is failed, decrease AP by 10
        AffectionManager.getInstance().decreaseAffection(captured, CatchAction.UNSUCCESSFUL_CATCHING);

        String result = "Capture " + captured + " is failed";
        return result;
    }

    /**
     * Refactoring method to capture the pokemon:
     *  Remove the ball from inventory
     *  set the pokemon inside the ball
     *  Return it back to the inventory
     *
     * @param actor actor who captures the pokemon
     * @param map the map the actor is on.
     * @return message whether capturing is success or fail
     */
    private String capturing(Actor actor, GameMap map){
        // remove it first to avoid having duplicate item
        actor.removeItemFromInventory(ball);

        // save the pokemon into the GeneralBall
        ball.setStoredPokemon(captured);

        // Add back the filledPokeball into inventory
        actor.addItemToInventory(ball);

        // add candy
        map.locationOf(captured).addItem(new Candy());

        // delete the captured pokemon from the map
        map.removeActor(captured);

        String result = "Capture " + captured + " is successful using " + ball;
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        PokemonBase pokemon = AffectionManager.getInstance().findPokemon(captured);
        return actor + " captures " + captured.toString() + "(" + AffectionManager.getInstance().getAffectionPoint(pokemon) + " AP) at " + direction + " using " + ball;
    }
}
