package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;
import game.tools.ElementsHelper;

public class Fire extends WeaponEffectItem {
    private static final int FIRE_DAMAGE = 10;

    public Fire(int duration) {
        super("Fire", 'v', duration);
        this.addCapability(Element.FIRE);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);

        if (location.getActor() != null) {
            if (!ElementsHelper.hasAnySimilarElements(location.getActor(), this.findCapabilitiesByType(Element.class))) {
                location.getActor().hurt(FIRE_DAMAGE);
                System.out.println(location.getActor() + " get hurts by " + this + ", -" + FIRE_DAMAGE + " HP");
            }
        }

        this.cleanUp(location);
    }
}
