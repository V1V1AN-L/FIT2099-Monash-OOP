package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.time.TimePerception;
import game.tools.Element;

import java.util.Random;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Zecan Liu
 *
 */
public class Lava extends Ground implements DestructibleGround, ExpandibleGround, TimePerception {

    private Element element;

    private Location location;

    /**
     * Constructor.
     */
    public Lava() {
        super('^');
        this.element = Element.FIRE;
        this.addCapability(this.element);
        registerInstance();
    }


    @Override
    public void dayEffect() {
        if (Math.random()<=0.1 && this.location != null){
            expandGround(this.location, new Lava(),Element.FIRE);
        }
    }

    @Override
    public void nightEffect() {
        if (Math.random()<=0.1 && this.location != null){
            destroyGround(this.location);
        }
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        this.location = location;
    }
}
