package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.tools.Element;
import game.tools.Status;

import java.util.ArrayList;
import java.util.List;
/**
 * The interface to realise the capability of expanding to neighbouring locations for a ground instance.
 */
public interface ExpandibleGround {
    /**
     * The expansion method for specific ground instances (e.g. Lava) enabling the expansion into adjacent locations.
     * Check through all adjacent location instances of the current location using the get.Exit() method for expanding
     * the current ground. Prior to updating the ground of a given location at successful expansion event, the original
     * ground instance of the location to be updated is firstly deleted from the timePerceptionList so that it is
     * eliminated from the game.
     *
     * @param location - The current location of the ground instance.
     * @param ground - The ground instance.
     * @param element - The element of the ground, which is used to check if expansion criteria is met.
     */
    default void expandGround(Location location, Ground ground, Element element){
        List<Exit> availableExits = new ArrayList<>(location.getExits());

        for(Exit exit: availableExits){
            if(!(exit.getDestination().getGround().hasCapability(Status.NONCONVERTIBLE))
                    && !(exit.getDestination().getGround().hasCapability(element))){
                for (TimePerception each: new ArrayList<TimePerception>(TimePerceptionManager.getInstance().getTimePerceptionList())){
                    if(exit.getDestination().getGround() == each){
                        TimePerceptionManager.getInstance().cleanUp(each);
                    }
                }
                exit.getDestination().setGround(ground);
            }
        }
    }
}
