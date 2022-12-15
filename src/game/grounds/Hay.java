package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.tools.Element;

public class Hay extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Hay(char displayChar) {
        super(',');
        addCapability(Element.GRASS);
    }




}
