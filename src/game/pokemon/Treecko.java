package game.pokemon;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.tools.Element;
import game.weapon.BackupWeapon;

/**
 * Concrete class of PokemonBase Treecko
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 * Modified by: Zecan (Vivian) Liu
 */
public class Treecko extends EvolvedPokemonBase  implements TimePerception {
    /**
     * Constructor.
     */
    public Treecko() {
        super("Treecko", 'b', 100);
        this.addCapability(Element.GRASS);
        this.favAction = FavoriteAction.DANCING;

        // register in timePerceiptionList
        registerInstance();
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }

    @Override
    protected BackupWeapon backupWeapon(){
        return new BackupWeapon("Blade Cutter", ' ', 20, "whips", 90, Element.GRASS);
    }

    @Override
    public PokemonBase evolve() {
        return new Grovyle(this.backupWeapons);
    }

    @Override
    public void dayEffect() {
        hurt(5);
        removeDeadPokemon();
    }

    @Override
    public void nightEffect() {
        heal(5);
    }

    private void removeDeadPokemon(){
        if(!isConscious()){
            TimePerceptionManager.getInstance().cleanUp(this);
        }
    }
}
