package game.pokemon;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapon;
import game.weapon.FireSpin;

import java.util.ArrayList;

/**
 * Concrete class of Blaziken - An evolution after Combusken
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Blaziken extends PokemonBase {
    /**
     * Constructor.
     *
     * @param oldBackupWeapons the previous weapons from the previous pokemon (before evolution)
     */
    public Blaziken(ArrayList<BackupWeapon> oldBackupWeapons) {
        super("Blaziken", 'Z', 250);
        this.addCapability(Element.FIRE);
        this.addCapability(Element.FIGHTING);
        this.favAction = FavoriteAction.SINGING;

        for (BackupWeapon backupWeapon : oldBackupWeapons){
            this.backupWeapons.add(backupWeapon);
        }
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "scratch");
    }

    @Override
    protected BackupWeapon backupWeapon(){
        return new FireSpin();
    }
}