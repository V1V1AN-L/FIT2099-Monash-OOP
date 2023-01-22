package game.items.stone;

import edu.monash.fit2099.engine.items.Item;

/**
 * Abstract class for Evolution Stone
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public abstract class Stone extends Item {
    /**
     * Constructor
     *
     * @param name
     * @param displayChar
     * @param portable
     */
    public Stone(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }
}
