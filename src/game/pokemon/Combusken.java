package game.pokemon;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapon;

import java.util.ArrayList;

/**
 * Concrete class of Combusken - An evolution after Torchic
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Combusken extends EvolvedPokemonBase {
    /**
     * Constructor.
     *
     * @param oldBackupWeapons the previous weapons from the previous pokemon (before evolution)
     */
    public Combusken(ArrayList<BackupWeapon> oldBackupWeapons) {
        super("Combusken", 'K', 150);
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
        return new BackupWeapon("Blaze", ' ', 50, "flares", 80, Element.FIRE);
    }

    @Override
    public PokemonBase evolve() {
        return new Blaziken(this.backupWeapons) ;
    }
}
