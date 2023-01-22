package game.action;

import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;

public class TeleportAction extends MoveActorAction {
    /**
     * A class extends MoveActorAction. Used by Door class to teleport player.
     * @param moveToLocation
     * @param direction
     */
    public TeleportAction(Location moveToLocation, String direction) {
        super(moveToLocation, direction);
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return a description to inform player
     */

    @Override
    public String menuDescription(Actor actor) {
        return actor + " enters " + direction;
    }
}
