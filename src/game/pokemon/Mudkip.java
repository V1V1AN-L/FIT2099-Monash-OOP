package game.pokemon;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.tools.Element;
import game.tools.Status;
import game.weapon.BackupWeapons;

/**
 * Concrete class of PokemonBase Mudkip
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 * Modified by: Zecan (Vivian) Liu
 */
public class Mudkip extends EvolvedPokemonBase  implements TimePerception {
    /**
     * Constructor.
     */
    public Mudkip() {
        super("Mudkip", 's', 100);
        this.addCapability(Element.WATER);
        this.addCapability(Status.CATCHABLE);
        this.favAction = FavoriteAction.CHEST_POUNDING;

        // register in timePerceiptionList
        registerInstance();
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }

    @Override
    protected BackupWeapons backupWeapon(){
        return new BackupWeapons("Water Blast", ' ', 25, "burbles", 80, Element.WATER, false);
    }

    @Override
    public PokemonBase evolve() {
        return null;
    }

    @Override
    public void dayEffect() {
        hurt(15);
        removeDeadPokemon();
    }

    @Override
    public void nightEffect() {
        heal(10);
    }

    private void removeDeadPokemon(){
        if(!isConscious()){
            TimePerceptionManager.getInstance().cleanUp(this);
        }
    }
}
