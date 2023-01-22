package game.weapon;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.items.weaponeffect.Barren;
import game.tools.Element;

/**
 * Concrete class of SpecialMove - SolarBeam
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public class SolarBeam extends BackupWeapon {
    /**
     * Duration of this special weapon effect
     */
    private final int SOLAR_BEAM_DURATION = 5;

    /**
     * Constructor
     */
    public SolarBeam(){
        super("Solar Beam", ' ', 80, "tornadoes", 95, Element.GRASS);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        for (Exit outer : currentLocation.getExits()) {
            for (Exit inner : outer.getDestination().getExits()){
                if (inner.getDestination().getGround().canActorEnter(inner.getDestination().getActor())){
                    Location targetLoc = inner.getDestination();

                    targetLoc.addItem(new Barren(SOLAR_BEAM_DURATION));
                }
            }
        }
    }
}


