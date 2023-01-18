package game.items.weaponeffect;

import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;
import game.tools.ElementsHelper;
import game.tools.Status;

public class Shock extends WeaponEffectItem {
    private static final int DAMAGE = 15;

    public Shock(int duration) {
        super("Shock", '!', duration);
        this.addCapability(Element.ELECTRIC);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);

        if (location.getActor() != null && location.getGround().canActorEnter(location.getActor())) {
            // will get hurt and can't move
            if (! location.getActor().hasCapability(Status.IMMUNE)){
                location.getActor().hurt(DAMAGE);
                location.getActor().addCapability(Status.MOVEMENT_RESTRICTED);
                System.out.println(location.getActor() + " get hurt by " + this + ", -" + DAMAGE + " HP");
            }
        }
        this.cleanUp(location);
    }

    @Override
    protected void cleanUp(Location loc) {
        super.cleanUp(loc);
        if (loc.getActor().hasCapability(Status.MOVEMENT_RESTRICTED)){
            loc.getActor().removeCapability(Status.MOVEMENT_RESTRICTED);
        }
    }
}