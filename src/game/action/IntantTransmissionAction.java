package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.*;


/**
 * InstantTransmissionAction is a concrete class that transports the player to a specified pokemon.
 * Created by: Aashlesha Gaur
 *
 * @author agau0008
 */

public class IntantTransmissionAction extends Action {

    private final Actor target;
    private final String targetName;

    public IntantTransmissionAction(Actor target){
        super();
        this.target = target;
        this.targetName = target.getClass().getSimpleName();
    }

    /**
     * @param actor that is being moved
     * @param map the map and it's location
     * @return the location of target (e.g, if target is Mudkip) and  the location of the  player which is
     * adjacent to the target's location
     */

    @Override
    public String execute(Actor actor, GameMap map) {

        Location targetLocation = getLocationOfActorOnMap(target, map);
        if(targetLocation == null){
            return "No "+this.targetName+" on the map yet!";
        } else {
            moveActorToClosestAvailableLocation(actor,targetLocation, map);
            return "Found "+this.targetName+", moving player to closest adjacent location of "+ this.targetName;
        }
    }

    //Looks to take actor to closest adjacent, if none available does nothing
    private void moveActorToClosestAvailableLocation(Actor actor, Location targetLocation, GameMap map) {
        //checks all 8 positions right,left,up down and diagonals
        int x = targetLocation.x();
        int y = targetLocation.y();
        if(!map.isAnActorAt(map.at(x+1,y))){
            map.moveActor(actor,map.at(x+1,y));
        }
        else if(!map.isAnActorAt(map.at(x-1,y))){
            map.moveActor(actor,map.at(x-1,y));
        }
        else if(!map.isAnActorAt(map.at(x,y+1))){
            map.moveActor(actor,map.at(x,y+1));
        }
        else if(!map.isAnActorAt(map.at(x,y-1))){
            map.moveActor(actor,map.at(x,y-1));
        }
        else if(!map.isAnActorAt(map.at(x-1,y+1))){
            map.moveActor(actor,map.at(x-1,y+1));
        }
        else if(!map.isAnActorAt(map.at(x+1,y+1))){
            map.moveActor(actor,map.at(x+1,y+1));
        }
        else if(!map.isAnActorAt(map.at(x-1,y-1))){
            map.moveActor(actor,map.at(x-1,y-1));
        }
        else if(!map.isAnActorAt(map.at(x+1,y-1))){
            map.moveActor(actor,map.at(x+1,y-1));
        }
    }


    /**
     * @return current location of actor.
     */

    public Location getLocationOfActorOnMap(Actor actor, GameMap map){
        NumberRange x = map.getXRange();
        NumberRange y = map.getYRange();

        for(int i = x.min(); i<x.max();i++){
            for(int j = y.min();j<y.max();j++){
                Location current =map.at(i,j);
                if(current.containsAnActor()){
                    if(map.getActorAt(current).getDisplayChar() == actor.getDisplayChar()){
                        return current;
                    };
                }
            }
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Goto Pokemon - "+targetName;
    }
}
