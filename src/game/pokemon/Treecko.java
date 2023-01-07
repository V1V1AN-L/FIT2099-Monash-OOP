package game.pokemon;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.tools.Status;
import game.weapon.BackupWeapons;

/**
 * Concrete class of PokemonBase Treecko
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 * Modified by: Zecan (Vivian) Liu
 */
public class Treecko extends PokemonBase{
    /**
     * Constructor.
     */
    public Treecko() {
        super("Treecko", 'b', 100);
        this.addCapability(Element.GRASS);
        this.addCapability(Status.CATCHABLE);
        this.favAction = FavoriteAction.DANCING;
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }

    @Override
    protected BackupWeapons backupWeapon(){
        return new BackupWeapons("Blade Cutter", ' ', 20, "whips", 90);
    }

    @Override
    public void dayEffect() {
        hurt(5);
    }

    @Override
    public void nightEffect() {
        heal(5);
    }
}
