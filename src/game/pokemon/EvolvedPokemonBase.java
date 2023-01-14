package game.pokemon;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.*;
import game.affection.AffectionLevelPoint;
import game.affection.AffectionManager;
import game.behaviours.BehaviourPriority;
import game.behaviours.EvolveBehaviour;
import game.weapon.BackupWeapons;

import java.util.ArrayList;

/**
 * Abstract EvolvedPokemonBase class
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public abstract class EvolvedPokemonBase extends PokemonBase{
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public EvolvedPokemonBase(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        behaviours.put(BehaviourPriority.EVOLVING.getValue(), new EvolveBehaviour(this));
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);

        if (AffectionManager.getInstance().getAffectionPoint(this) == AffectionLevelPoint.MAXIMUM.getValue()){
            actions.add(new EvolveAction(this, direction));
        }

        return actions;
    }

    protected abstract BackupWeapons backupWeapon();

    public abstract PokemonBase evolve();
}
