package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action.TeleportAction;
import game.tools.Status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Door extends Ground {

    private static Set<Location> doorLocationSet = new HashSet<>();

    private Location location;

    private Location anotherDoor;

    /**
     * Constructor.
     *
     */
    public Door() {
        super('=');
        this.addCapability(Status.NONCONVERTIBLE);
    }

    public Location getAnotherDoor(){
        for (Location doorLocation: doorLocationSet){
            if (doorLocation != this.location){
                anotherDoor =  doorLocation;
            }
        }
        return anotherDoor;
    }

    @Override
    public void tick(Location location) {
        this.location = location;
        doorLocationSet.add(location);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if(this.location.containsAnActor()&& this.location.getActor().hasCapability(Status.ENTERABLE)){
            if(this.location.y()==5){
                direction = "Pallet Town";
            }else{
                direction = "Pokermon Center";
            }
            return new ActionList(new TeleportAction(getAnotherDoor(),direction));
        }else{
            return new ActionList();
        }
    }

    public Set<Location> getDoorLocationSet() {
        return doorLocationSet;
    }

    public void setDoorLocationSet(Set<Location> doorLocationSet) {
        this.doorLocationSet = doorLocationSet;
    }

    public void setAnotherDoor(Location anotherDoor) {
        this.anotherDoor = anotherDoor;
    }
}
