package game.pokemon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.tools.Element;

public class Treecko extends PokemonBase{
    /**
     * Constructor.
     *
     */
    public Treecko() {
        super("Treecko", 'b', 100);
        this.addCapability(Element.GRASS);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }
}
