package game.weapon;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.items.weaponeffect.Fire;
import game.tools.Element;

/**
 * Concrete class of SpecialMove - FireSpin
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public class FireSpin extends BackupWeapon {
    /**
     * Duration of this special weapon effect
     */
    private final int FIRE_SPIN_DURATION = 2;

    /**
     * Constructor.
     */
    public FireSpin(){
        super("Fire Spin", ' ', 80, "tornadoes", 90, Element.FIRE);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        for (Exit exit : currentLocation.getExits()) {
            if (exit.getDestination().getGround().canActorEnter(exit.getDestination().getActor())){
                Location targetLoc = exit.getDestination();

                targetLoc.addItem(new Fire(FIRE_SPIN_DURATION));
            }
        }
    }
}
