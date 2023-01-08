package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.tools.Element;


/**
 * The class instance that represents a Lava ground
 * Capable of expand/destroy itself - implements Destructible-/Expandible-Ground.
 * Created by:
 * @author Zecan Liu
 *
 */

public class Puddle extends Ground implements DestructibleGround, ExpandibleGround, TimePerception {

    private Element element;

    private Location location;

    /**
     * Constructor.
     * Inherit from Ground.
     */
    public Puddle() {
        super('~');
        this.element = Element.WATER;
        addCapability(this.element);
        registerInstance();
    }
    /**
     * This tick method is used to update/define the location
     * This allows the ground object to store its corresponding location.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        this.location = location;
    }
    /**
     * The day-effect method for Puddle ground
     * This allows the Puddle to be destroyed if checked to do so, during the daytime
     */
    @Override
    public void dayEffect() {
        if (Math.random()<=0.1 && this.location != null)  {
            destroyGround(this.location);
            TimePerceptionManager.getInstance().cleanUp(this);
        }
    }
    /**
     * The night effect method for Puddle ground
     * This allows the puddle to expand into neighbouring locations
     */
    @Override
    public void nightEffect() {
        if(Math.random()<=0.1 && this.location != null){
            expandGround(this.location, new Puddle(), Element.WATER);
        }
    }

}
