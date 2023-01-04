package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;

import java.util.Locale;

public class Hay extends Ground {

    private Location location;
    /**
     * Constructor.
     *
     */
    public Hay() {
        super(',');
        addCapability(Element.GRASS);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        this.location = location;
    }
}
