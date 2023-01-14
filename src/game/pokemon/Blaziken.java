package game.pokemon;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.grounds.Fire;
import game.tools.Element;
import game.weapon.BackupWeapons;

import java.util.ArrayList;

/**
 *
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Blaziken extends PokemonBase{
    /**
     * Constructor.
     */
    public Blaziken(ArrayList<BackupWeapons> oldBackupWeapons) {
        super("Blaziken", 'Z', 250);
        this.addCapability(Element.FIRE);
        this.addCapability(Element.FIGHTING);
        this.favAction = FavoriteAction.SINGING;

        for (BackupWeapons backupWeapon : oldBackupWeapons){
            this.backupWeapons.add(backupWeapon);
        }
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "scratch");
    }

    @Override
    protected BackupWeapons backupWeapon(){
        BackupWeapons weapon = new BackupWeapons("Fire Spin", ' ', 80, "sparks", 90, Element.FIRE, true);
        return weapon;
    }

    public static void weaponEffect(Actor actor, GameMap map) {
        // check surrounding
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location targetLoc = exit.getDestination();

            targetLoc.setGround(new Fire());
        }
    }


}
