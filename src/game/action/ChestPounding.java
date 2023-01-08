package game.action;

import edu.monash.fit2099.engine.actors.Actor;
import game.pokemon.FavoriteAction;

/**
 * An concrete class to of AttractionAction to specify a specific attraction action
 * CHEST POUNDING
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class ChestPounding extends AttractionAction {
    /**
     * constructor
     *
     * @param target the actor that is to be attracted
     * @param direction the direction of incoming attraction
     */
    public ChestPounding(Actor target, String direction){
        super(target, direction, FavoriteAction.CHEST_POUNDING);
    }
}
