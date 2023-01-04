package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.affection.AffectionManager;
import game.pokemon.FavoriteAction;
import game.pokemon.PokemonBase;

public abstract class AttractionAction extends Action {
    /**
     * The actor that want to be summoned
     */
    protected Actor target;
    protected String direction;
    protected FavoriteAction favAction;
    private final static AffectionManager am = AffectionManager.getInstance();

    public AttractionAction(Actor target, String direction, FavoriteAction favAction){
        this.target = target;
        this.direction = direction;
        this.favAction = favAction;
    }

    public String execute(Actor actor, GameMap map){
        // FIXME change these magic number later (10 / 20)
        if (((PokemonBase) target).getFavoriteAction() == favAction){
            am.increaseAffection(target, 10);
            return target.toString() + " likes it! +10 affection points";
        }

        am.decreaseAffection(target, 20);
        return target.toString() + " dislikes it! -20 affection points";
    }

    @Override
    public String menuDescription(Actor actor) {
        int ap = am.getAffectionPoint((PokemonBase) target);
        String apString = Integer.toString(ap);
        return actor + " tries " + favAction.toString() + " with " + target + "(" + apString + " AP)" + " at " + direction;
    }
}
