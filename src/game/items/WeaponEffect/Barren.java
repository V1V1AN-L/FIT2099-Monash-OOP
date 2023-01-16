package game.items.WeaponEffect;

import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;
import game.tools.ElementsHelper;

public class Barren extends WeaponEffectItem {
    private static final int DAMAGE = 2;

    public Barren(int duration) {
        super("Barren", '\'', duration);
        this.addCapability(Element.GRASS);
        this.addCapability(Element.GROUND);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);

        if (location.getActor() != null && location.getGround().canActorEnter(location.getActor())) {
            // non same element will be hurted
            if (!ElementsHelper.hasAnySimilarElements(location.getActor(), this.findCapabilitiesByType(Element.class))) {
                location.getActor().hurt(DAMAGE);
                System.out.println(location.getActor() + " get hurt by " + this + ", -" + DAMAGE + " HP");
            }

            // same element will be healed
            if (ElementsHelper.hasAnySimilarElements(location.getActor(), this.findCapabilitiesByType(Element.class))){
                location.getActor().heal(DAMAGE);
                System.out.println(location.getActor() + " get heal by" + this + ", +" + DAMAGE + " HP");
            }
        }

        this.cleanUp(location);
    }
}
