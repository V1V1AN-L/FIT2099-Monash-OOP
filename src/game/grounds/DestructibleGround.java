package game.grounds;

import edu.monash.fit2099.engine.positions.Location;

public interface DestructibleGround {
    default void destroyGround(Location location){
        if (!location.containsAnActor()){
            location.setGround(new Dirt());
        }
    }
}
