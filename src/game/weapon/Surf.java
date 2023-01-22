package game.weapon;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.items.weaponeffect.Flood;
import game.tools.Element;

/**
 * Concrete class of SpecialMove - Surf
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public class Surf extends BackupWeapon {
    /**
     * Duration of this special weapon effect
     */
    private final int SURF_DURATION = 3;

    /**
     * Constructor.
     */
    public Surf(){
        super("Surf", ' ', 80, "tornadoes", 95, Element.WATER);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        for (Exit outer : currentLocation.getExits()) {
            for (Exit inner : outer.getDestination().getExits()){
                if (inner.getDestination().getGround().canActorEnter(inner.getDestination().getActor())){
                    Location targetLoc = inner.getDestination();

                    targetLoc.addItem(new Flood(SURF_DURATION));
                }
            }
        }
    }
}


