package game.pokemon;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.tools.Status;
import game.weapon.BackupWeapons;

/**
 * Created by: Riordan D. Alfredo
 *
 * @author Riordan D. Alfredo
 * Modified by: Jordan Nathanael, Zecan (Vivian) Liu
 */
public class Torchic extends PokemonBase {
    /**
     * Constructor.
     */
    public Torchic() {
        super("Torchic", 'c', 100);
        this.addCapability(Element.FIRE);
        this.addCapability(Status.UNCATCHABLE);
        this.favAction = FavoriteAction.SINGING;
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "scratch");
    }

    @Override
    protected BackupWeapons backupWeapon(){
        return new BackupWeapons("Ember", ' ', 30, "sparks", 65);
    }

    @Override
    public void dayEffect() {
        heal(20);
    }

    @Override
    public void nightEffect() {
        hurt(15);
        removeDeadPokemon();
    }
}
