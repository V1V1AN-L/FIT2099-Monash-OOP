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
import game.tools.Status;
import game.weapon.BackupWeapons;

import java.util.*;

/**
 * Abstract PokemonBase class
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 * Modified by: Zecan (Vivian) Liu
 */
public abstract class PokemonBase extends Actor{
    /**
     * List of behaviors that PokemonBase will do (the key that is the smallest is the first priority
     */
    protected final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour

    /**
     * PokemonBase favorite Action
     * @see game.pokemon.FavoriteAction
     */
    protected FavoriteAction favAction;

    /**
     * SpecialWeapons that can be used by the pokemonBase if the condition is met
     */
    protected ArrayList<BackupWeapons> backupWeapons = new ArrayList<>() ;


    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public PokemonBase(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        backupWeapons.add(backupWeapon());

        this.addCapability(Status.HOSTILE);

        behaviours.put(BehaviourPriority.TOGGLING.getValue(), new ToggleWeaponBehavior(this));
        behaviours.put(BehaviourPriority.ATTACKING.getValue(), new AttackBehaviour());
        behaviours.put(BehaviourPriority.WANDERING.getValue(), new WanderBehaviour());

        AffectionManager.getInstance().registerPokemon(this);
    }

    /**
     * Add follow behavior to the pokemon once the AP is met the requirements
     *
     * @param behaviour that want to be added
     */
    public void addBehaviours(Behaviour behaviour){
        behaviours.put(behaviour.getPriority(), behaviour);
    }

    /**
     * Delete follow behavior to the pokemon once the AP isn't met the requirements anymore
     */
    public void deleteBehaviours(BehaviourPriority whichBehavior){
        behaviours.remove(whichBehavior.getValue());
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
        display.println(this + getHp() +"(AP: "+ AffectionManager.getInstance().getAffectionPoint(this) + ") moves around" );

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
    public void toggleWeapon(boolean isEquipping, Actor actor, GameMap map){
        Random random = new Random();
        if (isEquipping){
            BackupWeapons weapon = backupWeapons.get(random.nextInt(backupWeapons.size()));
            // -1 because nextInt is inclusive which what we want is exclusive
            addItemToInventory(weapon);

            if (weapon.hasSpecialEffect()){
                weapon.uniqueWeaponSkill.weaponEffect(actor, map);
            }

        } else if (!isEquipping && getInventory().contains(getWeapon())) {
            int indexOfBackupWeapon = getInventory().indexOf(getWeapon());
            removeItemFromInventory(getInventory().get(indexOfBackupWeapon));
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

}
