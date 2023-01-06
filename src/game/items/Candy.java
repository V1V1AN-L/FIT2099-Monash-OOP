package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.tools.Status;

public class Candy extends Item {

    public Candy() {
        super("Candy", '*', true);
        addCapability(Status.TRADEBLE);
    }



    public String toString() {
        return "Candy";
    }
}
