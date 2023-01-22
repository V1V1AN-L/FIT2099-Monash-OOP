package game.pokemon;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapon;
import game.weapon.Surf;

import java.util.ArrayList;

/**
 * Concrete class of PokemonBase Vaporeon - An Evolution after Eevee
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public class Vaporeon extends PokemonBase {
    /**
     * Constructor.
     *
     * @param oldBackupWeapons the previous weapons from the previous pokemon (before evolution)
     */
    public Vaporeon(ArrayList<BackupWeapon> oldBackupWeapons) {
        super("Vaporeon", 'V', 250);
        this.addCapability(Element.WATER);
        this.favAction = FavoriteAction.CHEST_POUNDING;
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(12, "body slams");
    }

    @Override
    protected BackupWeapon backupWeapon(){
        return new Surf();
    }
}
