package game.pokemon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Element;

public class Mudkip extends PokemonBase{
    /**
     * Constructor.
     *
     *
     */
    public Mudkip() {
        super("Mudkip", 's', 100);
        this.addCapability(Element.WATER);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }
}
