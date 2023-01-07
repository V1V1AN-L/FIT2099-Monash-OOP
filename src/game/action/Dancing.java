package game.action;

import edu.monash.fit2099.engine.actors.Actor;
import game.pokemon.FavoriteAction;

/**
 * An concrete class to of AttractionAction to specify a specific attraction action
 * DANCING
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Dancing extends AttractionAction {
    /**
     * Constructor.
     *
     * @param target the actor that is to be attracted
     * @param direction the direction of incoming attraction.
     */
    public Dancing(Actor target, String direction){
        super(target, direction, FavoriteAction.DANCING);
    }
}