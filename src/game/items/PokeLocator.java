package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.action.IntantTransmissionAction;
import game.pokemon.Mudkip;
import game.pokemon.Torchic;
import game.pokemon.Treecko;

/**
 * PokeLocator is an item/device that the Player uses.
 * Created by: Aashlesha Gaur
 *
 * @author agau0008
 */

public  class PokeLocator extends Item {

    public PokeLocator() {
        super("PokeLocator", '!' ,false);
        this.addAction(new IntantTransmissionAction(new Mudkip()));
        this.addAction(new IntantTransmissionAction(new Torchic()));
        this.addAction(new IntantTransmissionAction(new Treecko()));

    }

}
