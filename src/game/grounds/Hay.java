package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.tools.Element;


/**
 *  A class that represents Hay.
 *  Created by:
 *  @author Zecan Liu
 */
public class Hay extends Ground {

    /**
     * Constructor.
     * Inherit from Ground.
     * Set the display character to ','
     */
    public Hay() {
        super(',');
        addCapability(Element.GRASS);
    }

}
