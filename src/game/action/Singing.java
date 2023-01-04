package game.action;

import edu.monash.fit2099.engine.actors.Actor;
import game.pokemon.FavoriteAction;

public class Singing extends AttractionAction {
    public Singing(Actor target, String direction){
        super(target, direction, FavoriteAction.SINGING);
    }
}