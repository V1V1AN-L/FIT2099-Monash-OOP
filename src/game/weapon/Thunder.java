package game.weapon;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.items.weaponeffect.Shock;
import game.tools.Element;

import java.util.Random;

public class Thunder extends BackupWeapons{
    private final int THUNDER_DURATION = 2;

    public Thunder(){
        super("Thunder", ' ', 100, "shocks", 40, Element.ELECTRIC);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        for (Exit exit : currentLocation.getExits()) {
            Random random = new Random();
            if (exit.getDestination().getGround().canActorEnter(exit.getDestination().getActor()) && random.nextInt(2) == 1){
                Location targetLoc = exit.getDestination();

                targetLoc.addItem(new Shock(THUNDER_DURATION));
            }
        }
    }
}


