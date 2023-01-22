package game.pokemon;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapon;
import game.weapon.Surf;

import java.util.ArrayList;

/**
 * Concrete class of Swampert - An evolution after Marshtomp
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Swampert extends PokemonBase {
    /**
     * Constructor.
     *
     * @param oldBackupWeapons the previous weapons from the previous pokemon (before evolution)
     */
    public Swampert(ArrayList<BackupWeapon> oldBackupWeapons) {
        super("Swampert", 'N', 250);
        this.addCapability(Element.WATER);
        this.addCapability(Element.GROUND);
        this.favAction = FavoriteAction.SINGING;

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
        return new Surf();
    }
}
