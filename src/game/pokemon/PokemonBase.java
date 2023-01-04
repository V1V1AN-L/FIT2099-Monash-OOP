package game.pokemon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.*;
import game.affection.AffectionManager;
import game.behaviours.*;
import game.time.TimePerception;
import game.weapon.BackupWeapons;

import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public abstract class PokemonBase extends Actor implements TimePerception {
    //FIXME: Change it to a sorted map (is it TreeMap? HashMap? LinkedHashMap?)
    //Using TreeMap because I need the order of the behaviors.
    protected final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour
    private final AffectionManager am = AffectionManager.getInstance();
    protected FavoriteAction favAction;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public PokemonBase(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        // Create the SpecialWeapons
        backupWeapon();

        // These two behaviors are a mush for each pokemon
        // FIXME change the order key to final variable instead of magic number
        behaviours.put(0, new ToogleWeaponBehavior(this));
        behaviours.put(1, new AttackBehaviour());
        behaviours.put(3, new WanderBehaviour());
        registerInstance();

        am.registerPokemon(this);
    }

    // there is a key needed, but we know that the only behavior left is followBehavior, maybe I can use ENUM for the key
    // the actor is the trainer
    public void addFollowBehaviours(Actor actor){
        behaviours.put(2, new FollowBehaviour(actor));
    }

    public void deleteFollowBehaviours(){
        behaviours.remove(2);
    }

    /**
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(this, direction));
        actions.add(new CatchAction(this, direction));
        actions.add(new Dancing(this, direction));
        actions.add(new ChestPounding(this, direction));
        actions.add(new Singing(this, direction));
        return actions;
    }

    /**
     * By using behaviour loops, it will decide what will be the next action automatically.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * @param isEquipping FIXME: develop a logic to toggle weapon (put a selected weapon to the inventory - used!);
     * What I get from toggleWeapon is like
     * because the condition for equipping specialWeapon is triggered, now we are using the special weapon.
     * However, once the actor is moved, and the condition isn't matched, so the actor will go back again into the intrinsic weapon... maybe
     */
    public void toggleWeapon(boolean isEquipping){
        if (isEquipping){
            addItemToInventory(BackupWeapons.getBackupWeapons(this));
        } else if (!isEquipping && getInventory().contains(BackupWeapons.getBackupWeapons(this))) {
            removeItemFromInventory((Item) getWeapon());
        }
    };

    public FavoriteAction getFavoriteAction(){
        return this.favAction;
    }

    public abstract void backupWeapon();
}
