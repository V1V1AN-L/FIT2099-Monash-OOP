package game.items.weaponeffect;

import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;
import game.tools.ElementsHelper;
import game.tools.Status;

public class Fire extends WeaponEffectItem {
    private static final int DAMAGE = 10;

    public Fire(int duration) {
        super("Fire", 'v', duration);
        this.addCapability(Element.FIRE);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);

        if (location.getActor() != null) {
            if (!ElementsHelper.hasAnySimilarElements(location.getActor(), this.findCapabilitiesByType(Element.class))) {
                if (! location.getActor().hasCapability(Status.IMMUNE)){
                    location.getActor().hurt(DAMAGE);
                    System.out.println(location.getActor() + " get hurt by " + this + ", -" + DAMAGE + " HP");
                }
            }
        }

        this.cleanUp(location);
    }
}
