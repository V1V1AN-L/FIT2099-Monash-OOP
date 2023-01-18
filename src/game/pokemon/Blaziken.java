package game.pokemon;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapons;
import game.weapon.FireSpin;

import java.util.ArrayList;

/**
 *
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Blaziken extends PokemonBase {

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
        return new FireSpin();
    }
}