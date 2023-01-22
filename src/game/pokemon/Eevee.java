package game.pokemon;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.stone.WaterStone;
import game.tools.Element;
import game.weapon.BackupWeapon;

/**
 * Concrete class of PokemonBase Eevee
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public class Eevee extends RestrictedEvolvedPokemonBase {
    /**
     * Constructor.
     */
    public Eevee() {
        super("Eevee", 'e', 100, WaterStone.NAME);
        this.addCapability(Element.NORMAL);
        this.favAction = FavoriteAction.CHEST_POUNDING;
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(12, "body slams");
    }

    @Override
    protected BackupWeapon backupWeapon(){ return new BackupWeapon("Swift", ' ', 35, "scratches", 100, Element.NORMAL); }

    @Override
    public PokemonBase evolve() {
        return new Vaporeon(this.backupWeapons);
    }
}
