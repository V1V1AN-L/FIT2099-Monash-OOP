package game.action;

import edu.monash.fit2099.engine.actors.Actor;
import game.pokemon.FavoriteAction;

public class ChestPounding extends AttractionAction {
    public ChestPounding(Actor target, String direction){
        super(target, direction, FavoriteAction.CHEST_POUNDING);
    }
}
