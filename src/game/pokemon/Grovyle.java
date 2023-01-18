package game.pokemon;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapons;

import java.util.ArrayList;

/**
 *
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Grovyle extends EvolvedPokemonBase {
    /**
     * Constructor.
     */
    public Grovyle(ArrayList<BackupWeapons> oldBackupWeapons) {
        super("Grovyle", 'G', 150);
        this.addCapability(Element.WATER);
        this.favAction = FavoriteAction.CHEST_POUNDING;

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
        return new BackupWeapons("Leaf Storm", ' ', 75, "whips", 65, Element.GRASS);
    }

    @Override
    public PokemonBase evolve() {
        this.backupWeapons.clear();
        return new Swampert(this.backupWeapons) ;
    }
}
