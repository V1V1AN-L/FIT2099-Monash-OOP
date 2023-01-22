package game.pokemon;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.stone.ThunderStone;
import game.tools.Element;
import game.weapon.BackupWeapon;

/**
 * Concrete class of PokemonBase Pikachu
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public class Pikachu extends RestrictedEvolvedPokemonBase {
    /**
     * Constructor.
     */
    public Pikachu() {
        super("Pikachu", 'p', 100, ThunderStone.NAME);
        this.addCapability(Element.ELECTRIC);
        this.favAction = FavoriteAction.DANCING;
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(12, "body slams");
    }

    @Override
    protected BackupWeapon backupWeapon(){
        return new BackupWeapon("Thunder Strike", ' ', 30, "strikes", 75, Element.ELECTRIC);
    }

    @Override
    public PokemonBase evolve() {
        return new Raichu(this.backupWeapons);
    }
}
