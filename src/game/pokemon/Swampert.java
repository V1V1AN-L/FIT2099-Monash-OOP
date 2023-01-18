package game.pokemon;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapons;
import game.weapon.Surf;

import java.util.ArrayList;

/**
 *
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Swampert extends PokemonBase {

    /**
     * Constructor.
     */
    public Swampert(ArrayList<BackupWeapons> oldBackupWeapons) {
        super("Swampert", 'N', 250);
        this.addCapability(Element.WATER);
        this.addCapability(Element.GROUND);
        this.favAction = FavoriteAction.SINGING;

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
        return new Surf();
    }
}
