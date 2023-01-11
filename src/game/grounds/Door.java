package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.tools.Status;

public class Door extends Ground {


    /**
     * Constructor.
     *
     */
    public Door() {
        super('=');

    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        if(location.containsAnActor() && location.getActor().hasCapability(Status.ENTERABLE)){

        }
    }
}
