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
public class Marshtomp extends EvolvedPokemonBase {
    /**
     * Constructor.
     */
    public Marshtomp(ArrayList<BackupWeapons> oldBackupWeapons) {
        super("Marshtomp", 'M', 150);
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
        return new BackupWeapons("Water Gun", ' ', 40, "splashes", 95, Element.WATER);
    }

    @Override
    public PokemonBase evolve() {
        this.backupWeapons.clear();
        return new Swampert(this.backupWeapons) ;
    }
}
