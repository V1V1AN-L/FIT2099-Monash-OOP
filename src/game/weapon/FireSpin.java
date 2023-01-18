package game.weapon;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.items.WeaponEffect.Fire;
import game.tools.Element;

public class FireSpin extends BackupWeapons{
    private final int FIRE_SPIN_DURATION = 2;

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
