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
 * @author Riordan D. Alfredo
 * Modified by:
 * Zecan Liu
 *
 */
public class Lava extends Ground implements DestructibleGround, ExpandibleGround, TimePerception {

    private Element element;
    //The corresponding location for this ground
    private Location location;

    /**
     * Constructor.
     * Inherit from Ground.
     */
    public Lava() {
        super('^');
        this.element = Element.FIRE;
        this.addCapability(this.element);
        //Register the Lava ground into the time perception managing list, when Lava is first created
        registerInstance();
    }

    /**
     * The day-effect method for Lava ground
     * This allows the Lava to expand into its neighbouring locations
     */
    @Override
    public void dayEffect() {
        if (Math.random()<=0.1 && this.location != null){
            expandGround(this.location, new Lava(),Element.FIRE);
        }
    }

    /**
     * The night effect method for Lava ground
     * This allows the Lava to be destroyed if checked to do so.0
     */
    @Override
    public void nightEffect() {
        if (Math.random()<=0.1 && this.location != null){
            destroyGround(this.location);
            //Delete this lava from the time-managing list
            TimePerceptionManager.getInstance().cleanUp(this);
        }
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
}
