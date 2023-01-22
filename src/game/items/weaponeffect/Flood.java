package game.items.weaponeffect;

import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;
import game.tools.ElementsHelper;
import game.tools.Status;

/**
 * Concrete class of Flood Effect
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public class Flood extends WeaponEffectItem {
    /**
     * Damage each turn
     */
    private static final int DAMAGE = 3;

    /**
     * Constructor
     *
     * @param duration of the weaponEffect
     */
    public Flood(int duration) {
        super("Flood", '-', duration);
        this.addCapability(Element.WATER);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);

        if (location.getActor() != null && location.getGround().canActorEnter(location.getActor())) {
            // will get hurt and can't move
            if (!ElementsHelper.hasAnySimilarElements(location.getActor(), this.findCapabilitiesByType(Element.class))) {
                if (! location.getActor().hasCapability(Status.IMMUNE)){
                    location.getActor().hurt(DAMAGE);
                    location.getActor().addCapability(Status.MOVEMENT_RESTRICTED);
                    System.out.println(location.getActor() + " get hurt by " + this + ", -" + DAMAGE + " HP");
                }
            }
        }
        this.cleanUp(location);
    }

    @Override
    protected void cleanUp(Location loc) {
        super.cleanUp(loc);
        if (loc.containsAnActor()) {
            if (loc.getActor().hasCapability(Status.MOVEMENT_RESTRICTED)) {
                loc.getActor().removeCapability(Status.MOVEMENT_RESTRICTED);
            }
        }
    }
}