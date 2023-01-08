package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.tools.Status;

/**
 * Candy can be used to be traded as exchange value
 * Created by: Zecan (Vivian) Liu
 *
 * @author zliu0207
 */
public class Candy extends Item {
    /**
     * Constructor.
     */
    public Candy() {
        super("Candy", '*', true);
        addCapability(Status.TRADEBLE);
    }
}
