package game.action;

import edu.monash.fit2099.engine.actors.Actor;
import game.pokemon.FavoriteAction;

public class Dancing extends AttractionAction {
    public Dancing(Actor target, String direction){
        super(target, direction, FavoriteAction.DANCING);
    }
}