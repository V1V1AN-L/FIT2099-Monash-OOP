package game.pokemon;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapons;
import game.weapon.Thunder;

import java.util.ArrayList;

/**
 *
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Raichu extends PokemonBase{

    /**
     * Constructor.
     */
    public Raichu(ArrayList<BackupWeapons> oldBackupWeapons) {
        super("Raichu", 'I', 250);
        this.addCapability(Element.ELECTRIC);
        this.favAction = FavoriteAction.SINGING;

        for (BackupWeapons backupWeapon : oldBackupWeapons){
            this.backupWeapons.add(backupWeapon);
        }
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(12, "double-scratch");
    }

    @Override
    protected BackupWeapons backupWeapon(){
        return new Thunder();
    }
}
