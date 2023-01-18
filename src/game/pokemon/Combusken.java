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
public class Combusken extends EvolvedPokemonBase {
    /**
     * Constructor.
     */
    public Combusken(ArrayList<BackupWeapons> oldBackupWeapons) {
        super("Combusken", 'K', 150);
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
        return new BackupWeapons("Blaze", ' ', 50, "flares", 80, Element.FIRE);
    }

    @Override
    public PokemonBase evolve() {
        return new Blaziken(this.backupWeapons) ;
    }
}
