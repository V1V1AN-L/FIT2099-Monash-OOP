package game.weapon;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.items.weaponeffect.Flood;
import game.tools.Element;

public class Surf extends BackupWeapons{
    private final int SURF_DURATION = 3;

    public Surf(){
        super("Surf", ' ', 80, "tornadoes", 95, Element.WATER);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        for (Exit inner : currentLocation.getExits()) {
            for (Exit outer : inner.getDestination().getExits()){
                if (outer.getDestination().getGround().canActorEnter(outer.getDestination().getActor())){
                    Location targetLoc = outer.getDestination();

                    targetLoc.addItem(new Flood(SURF_DURATION));
                }
            }
        }
    }
}


