package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;

import java.util.Random;

public class Puddle extends ConvertibleGrounds{
    /**
     * Constructor.
     *
     */
    public Puddle() {
        super('~');
        this.element = Element.WATER;
        addCapability(this.element);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        this.location = location;
    }

    @Override
    public void dayEffect() {
        if (Math.random()<=0.1 && this.location != null)  {
            destroyGround();
        }
    }

    @Override
    public void nightEffect() {
        if(Math.random()<=0.1 && this.location != null){
            expandGround(new Puddle());
        }
    }
}
