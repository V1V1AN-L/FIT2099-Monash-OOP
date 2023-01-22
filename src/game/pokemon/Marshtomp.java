package game.pokemon;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapon;

import java.util.ArrayList;

/**
 * Concrete class of Marshtomp - an evolution after mudkip
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Marshtomp extends EvolvedPokemonBase {
    /**
     * Constructor.
     *
     * @param oldBackupWeapons the previous weapons from the previous pokemon (before evolution)
     */
    public Marshtomp(ArrayList<BackupWeapon> oldBackupWeapons) {
        super("Marshtomp", 'M', 150);
        this.addCapability(Element.WATER);
        this.favAction = FavoriteAction.CHEST_POUNDING;

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
        return new BackupWeapon("Water Gun", ' ', 40, "splashes", 95, Element.WATER);
    }


    @Override
    public PokemonBase evolve() {
        this.backupWeapons.clear();
        return new Swampert(this.backupWeapons) ;
    }
}
