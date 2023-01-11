package game.pokemon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.*;
import game.affection.AffectionManager;
import game.behaviours.*;
import game.items.Pokeball;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.tools.Status;
import game.weapon.BackupWeapons;
import java.util.TreeMap;
import java.util.Map;

/**
 * Abstract PokemonBase class
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 * Modified by: Zecan (Vivian) Liu
 */
public abstract class PokemonBase extends Actor implements TimePerception {
    /**
     * List of behaviors that PokemonBase will do (the key that is the smallest is the first priority
     */
    protected final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour

    /**
     * PokemonBase favorite Action
     * @see game.pokemon.FavoriteAction
     */
    protected FavoriteAction favAction;
    // This is a reference list collecting all available Pokemons by their display characteristics (without repetition)
    /**
     * SpecialWeapons that can be used by the pokemonBase if the condition is met
     */
    private BackupWeapons backupWeapon;


    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public PokemonBase(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        backupWeapon = backupWeapon();

        addCapability(Status.HOSTILE);

        behaviours.put(BehaviorPriority.TOGGLING.getValue(), new ToggleWeaponBehavior(this));
        behaviours.put(BehaviorPriority.ATTACKING.getValue(), new AttackBehaviour());
        behaviours.put(BehaviorPriority.WANDERING.getValue(), new WanderBehaviour());

        // register in timePerceiptionList
        registerInstance();

        AffectionManager.getInstance().registerPokemon(this);

    }

    /**
     * Add follow behavior to the pokemon once the AP is met the requirements
     *
     * @param actor the actor that want to be added followBehavior
     */

    // there is a key needed, but we know that the only behavior left is followBehavior, maybe I can use ENUM for the key
    // the actor is the trainer
    public void addFollowBehaviours(Actor actor){
        behaviours.put(BehaviorPriority.FOLLOWING.getValue(), new FollowBehaviour(actor));
    }

    /**
     * Delete follow behavior to the pokemon once the AP isn't met the requirements anymore
     */
    public void deleteFollowBehaviours(){
        behaviours.remove(BehaviorPriority.FOLLOWING.getValue());
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        if (otherActor.hasCapability(Status.HOSTILE)){
            actions.add(new AttackAction(this, direction));
        }

        if (this.hasCapability(Status.CATCHABLE)){
            actions.add(new CatchAction(this, direction, new Pokeball()));
        }
        actions.add(new Dancing(this, direction));
        actions.add(new ChestPounding(this, direction));
        actions.add(new Singing(this, direction));
        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        display.println(this.toString() + getHp() +"(AP: "+ AffectionManager.getInstance().getAffectionPoint(this) + ") moves around" );

        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * if this pokemon stand on the same element with the ground, get the weapon from its attribute backupWeapon and add it into inventory.
     * Otherwise, remove it from inventory
     *
     * @param isEquipping boolean expression whether the condition is met or not
     */
    public void toggleWeapon(boolean isEquipping){
        if (isEquipping){
            addItemToInventory(backupWeapon);
        } else if (!isEquipping && getInventory().contains(getWeapon())) {
            removeItemFromInventory(backupWeapon);
        }
    };

    /**
     * Get the favorite action of this pokemon
     *
     * @return the favoriteAction
     */
    public FavoriteAction getFavoriteAction(){
        return this.favAction;
    }

    /**
     * Create backupWeapons based on the concrete class needs
     * This method will be overridden by the concrete class.
     *
     * @return
     */
    protected abstract BackupWeapons backupWeapon();



    public String getHp(){
        return printHp();
    }

    protected void removeDeadPokemon(){
        if(!isConscious()){
            TimePerceptionManager.getInstance().cleanUp(this);
        }
    }

}
