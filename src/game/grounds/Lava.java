package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;

import java.util.Random;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Zecan Liu
 *
 */
public class Lava extends ConvertibleGrounds {

    /**
     * Constructor.
     */
    public Lava() {
        super('^');
        this.element = Element.FIRE;
        this.addCapability(this.element);
    }


    @Override
    public void dayEffect() {
        if (Math.random()<=0.1 && this.location != null){
            expandGround(new Lava());
        }
    }

    @Override
    public void nightEffect() {
        if (Math.random()<=0.1 && this.location != null){
            destroyGround();
        }
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        this.location = location;
    }
}
