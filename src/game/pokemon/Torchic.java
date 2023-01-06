package game.pokemon;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.time.TimePerceptionManager;
import game.tools.Element;
import game.action.AttackAction;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.tools.Status;
import game.weapon.BackupWeapons;
import game.weapon.SpecialWeapons;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by: Ian K. Felix
 */
public class Torchic extends PokemonBase {
    /**
     * Constructor.
     */
    public Torchic() {
        super("Torchic", 'c', 100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.FIRE);
        this.addCapability(Status.UNCATCHABLE);
        this.favAction = FavoriteAction.SINGING;
        // add followBehaviours once the pokemon AP is higher than a certain point
        // but behaviors is final attribute .-. think later
        // or maybe just put it now
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "scratch");
    }

    @Override
    public void backupWeapon(){
        new SpecialWeapons(this, "Ember", ' ', 30, "sparks", 65);
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
