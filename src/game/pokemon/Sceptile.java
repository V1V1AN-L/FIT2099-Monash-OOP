package game.pokemon;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapons;
import game.weapon.SolarBeam;

import java.util.ArrayList;

/**
 *
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Sceptile extends PokemonBase {

    /**
     * Constructor.
     */
    public Sceptile(ArrayList<BackupWeapons> oldBackupWeapons) {
        super("Sceptile", 'L', 250);
        this.addCapability(Element.GRASS);
        this.addCapability(Element.GROUND);
        this.favAction = FavoriteAction.DANCING;

        for (BackupWeapons backupWeapon : oldBackupWeapons){
            this.backupWeapons.add(backupWeapon);
        }
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }

    @Override
    protected BackupWeapons backupWeapon(){
        return new SolarBeam();
    }
}
