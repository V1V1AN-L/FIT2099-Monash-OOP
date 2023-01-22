package game.pokemon;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapon;
import game.weapon.SolarBeam;

import java.util.ArrayList;

/**
 * Concrete class of Sceptile - An evolution after Grovyle
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Sceptile extends PokemonBase {
    /**
     * Constructor.
     *
     * @param oldBackupWeapons the previous weapons from the previous pokemon (before evolution)
     */
    public Sceptile(ArrayList<BackupWeapon> oldBackupWeapons) {
        super("Sceptile", 'L', 250);
        this.addCapability(Element.GRASS);
        this.addCapability(Element.GROUND);
        this.favAction = FavoriteAction.DANCING;

        for (BackupWeapon backupWeapon : oldBackupWeapons){
            this.backupWeapons.add(backupWeapon);
        }
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }

    @Override
    protected BackupWeapon backupWeapon(){
        return new SolarBeam();
    }
}
