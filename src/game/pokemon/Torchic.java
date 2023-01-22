package game.pokemon;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.tools.Element;
import game.weapon.BackupWeapon;

/**
 * Created by: Riordan D. Alfredo
 *
 * @author Riordan D. Alfredo
 * Modified by: Jordan Nathanael, Zecan (Vivian) Liu
 */
public class Torchic extends EvolvedPokemonBase implements TimePerception {
    /**
     * Constructor.
     */
    public Torchic() {
        super("Torchic", 'c', 100);
        this.addCapability(Element.FIRE);
        this.favAction = FavoriteAction.SINGING;

        // register in timePerceptionList
        registerInstance();
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "scratch");
    }

    @Override
    protected BackupWeapon backupWeapon(){
        return new BackupWeapon("Ember", ' ', 30, "sparks", 65, Element.FIRE);
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

    @Override
    public PokemonBase evolve() {
        return new Combusken(backupWeapons);
    }

    private void removeDeadPokemon(){
        if(!isConscious()){
            TimePerceptionManager.getInstance().cleanUp(this);
        }
    }
}
