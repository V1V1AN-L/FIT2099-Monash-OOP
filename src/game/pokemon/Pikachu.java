package game.pokemon;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.tools.Status;
import game.weapon.BackupWeapons;

/**
 * Concrete class of PokemonBase Pikachu
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public class Pikachu extends EvolvedPokemonBase {
    /**
     * Constructor.
     */
    public Pikachu() {
        super("Pikachu", 'p', 100);
        this.addCapability(Element.ELECTRIC);
        this.favAction = FavoriteAction.DANCING;
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(12, "body slams");
    }

    @Override
    protected BackupWeapons backupWeapon(){
        return new BackupWeapons("Thunder Strike", ' ', 30, "strikes", 75, Element.ELECTRIC);
    }

    @Override
    public PokemonBase evolve() {
        return new Raichu(this.backupWeapons);
    }

}
