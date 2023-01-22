package game.pokemon;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapon;
import game.weapon.Thunder;

import java.util.ArrayList;

/**
 * Concrete class of Raichu - An evolution after Pikachu
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Raichu extends PokemonBase{
    /**
     * Constructor.
     *
     * @param oldBackupWeapons the previous weapons from the previous pokemon (before evolution)
     */
    public Raichu(ArrayList<BackupWeapon> oldBackupWeapons) {
        super("Raichu", 'I', 250);
        this.addCapability(Element.ELECTRIC);
        this.favAction = FavoriteAction.SINGING;

        for (BackupWeapon backupWeapon : oldBackupWeapons){
            this.backupWeapons.add(backupWeapon);
        }
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(12, "double-scratch");
    }

    @Override
    protected BackupWeapon backupWeapon(){
        return new Thunder();
    }
}
