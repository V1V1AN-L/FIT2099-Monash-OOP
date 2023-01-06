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

public interface ExpandibleGround {
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
