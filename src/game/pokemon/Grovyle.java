package game.pokemon;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapon;

import java.util.ArrayList;

/**
 * Concrete class of Grovyle - An evolution after Treecko
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Grovyle extends EvolvedPokemonBase {
    /**
     * Constructor.
     *
     * @param oldBackupWeapons the previous weapons from the previous pokemon (before evolution)
     */
    public Grovyle(ArrayList<BackupWeapon> oldBackupWeapons) {
        super("Grovyle", 'G', 150);
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
        return new BackupWeapon("Leaf Storm", ' ', 75, "whips", 65, Element.GRASS);
    }

    @Override
    public PokemonBase evolve() {
        this.backupWeapons.clear();
        return new Sceptile(this.backupWeapons) ;
    }
}
