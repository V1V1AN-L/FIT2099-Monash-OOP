package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.affection.AffectionManager;
import game.pokemon.FavoriteAction;
import game.pokemon.PokemonBase;
import game.tools.Status;

/**
 * An abstract action to attract another actor
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public abstract class AttractionAction extends Action {
    /**
     * Fixed value to increase the AP if attraction is successful
     */
    public static final int SUCCESSFUL_ATTRACTION = 10;

    /**
     * Fixed value to decrease the AP if attraction is unsuccessful
     */
    public static final int UNSUCCESSFUL_ATTRACTION = 20;

    /**
     * The actor that want to be summoned
     */
    protected Actor target;

    /**
     * The direction of incoming attraction
     */
    protected String direction;

    /**
     * The favorite action of this action
     */
    protected FavoriteAction favAction;

    /**
     * Constructor.
     *
     * @param target the target to attract
     * @param direction the direction of incoming attraction
     * @param favAction the favorite action of the attraction
     */
    public AttractionAction(Actor target, String direction, FavoriteAction favAction){
        this.target = target;
        this.direction = direction;
        this.favAction = favAction;
    }

    /**
     * Execute the attraction action:
     *  check if the action's favorite action is same with target or not
     *  if the pokemon is already dislike to everyone (AP level point)
     *      can't increase the affection point
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    public String execute(Actor actor, GameMap map){
        PokemonBase pokemon = AffectionManager.getInstance().findPokemon(this.target);
        if (pokemon.getFavoriteAction() == favAction){
            if (! pokemon.hasCapability(Status.RUINED_RELATIONSHIP)){
                AffectionManager.getInstance().increaseAffection(target, AttractionAction.SUCCESSFUL_ATTRACTION);
                return target.toString() + " likes it! +" + AttractionAction.SUCCESSFUL_ATTRACTION + " affection points";
            }
            return pokemon + "'s affection point can't be fixed. Use masterball to fix it!!!";
        }

        AffectionManager.getInstance().decreaseAffection(target, AttractionAction.UNSUCCESSFUL_ATTRACTION);
        return target.toString() + " dislikes it! -" + AttractionAction.UNSUCCESSFUL_ATTRACTION + " affection points";
    }

    @Override
    public String menuDescription(Actor actor) {
        int ap = AffectionManager.getInstance().getAffectionPoint((PokemonBase) target);
        String apString = Integer.toString(ap);
        return actor + " tries " + favAction.toString() + " with " + target + "(" + apString + " AP)" + " at " + direction;
    }
}
