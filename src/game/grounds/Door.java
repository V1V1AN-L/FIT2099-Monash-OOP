package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action.TeleportAction;
import game.tools.Status;

import java.util.ArrayList;
import java.util.List;

public class Door extends Ground {
    private Location anotherDoor;

    /**
     *
     * @param anotherDoor
     */

    public Door(Location anotherDoor) {
        super('=');
        this.addCapability(Status.NONCONVERTIBLE);
        this.anotherDoor = anotherDoor;
    }

    /**
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if(location.containsAnActor()&& location.getActor().hasCapability(Status.ENTERABLE)){
            if(location.y()==5){
                direction = "Pallet Town";
            }else{
                direction = "Pokermon Center";
            }
            return new ActionList(new TeleportAction(anotherDoor,direction));
        }else{
            return new ActionList();
        }
    }

    /**
     *
     * @param anotherDoor
     */

    public void setAnotherDoor(Location anotherDoor) {
        this.anotherDoor = anotherDoor;
    }

    /**
     *
     * @return anotherDoor
     */
    public Location getAnotherDoor() {
        return anotherDoor;
    }
}
