package game.action;

import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;

public class TeleportAction extends MoveActorAction {
    public TeleportAction(Location moveToLocation, String direction) {
        super(moveToLocation, direction);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " enters " + direction;
    }
}
