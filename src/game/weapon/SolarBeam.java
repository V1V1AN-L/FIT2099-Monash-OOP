package game.weapon;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.items.weaponeffect.Barren;
import game.tools.Element;

public class SolarBeam extends BackupWeapons{
    private final int SOLAR_BEAM_DURATION = 5;

    public SolarBeam(){
        super("Solar Beam", ' ', 80, "tornadoes", 95, Element.GRASS);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        for (Exit exit : currentLocation.getExits()) {
            for (Exit exit2 : exit.getDestination().getExits()){
                if (exit2.getDestination().getGround().canActorEnter(exit2.getDestination().getActor())){
                    Location targetLoc = exit2.getDestination();

                    targetLoc.addItem(new Barren(SOLAR_BEAM_DURATION));
                }
            }
        }
    }
}


