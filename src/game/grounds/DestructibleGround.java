package game.grounds;

import edu.monash.fit2099.engine.positions.Location;

/**
 * The interface to realise the capability of self-destructing for a ground instance.
 */
public interface DestructibleGround {
    /**
     * The destruction method for a ground instance, which is activated from the random checks as ran by the time
     * perception manager. A specific ground instance could then undergo self-destruction - reset the ground of the
     * current location to 'Dirt'.
     *
     * @param location The location of the ground instance. This is to update the location ground instance.
     */
    default void destroyGround(Location location){
        location.setGround(new Dirt());
    }
}
