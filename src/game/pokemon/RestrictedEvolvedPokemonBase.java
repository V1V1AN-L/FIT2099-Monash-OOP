package game.pokemon;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.EvolveAction;
import game.affection.AffectionLevelPoint;
import game.affection.AffectionManager;
import game.behaviours.BehaviourPriority;
import game.tools.Status;

/**
 * Abstract class RestrictedEvolvedPokemonBase
 * Used for any pokemon that need item to evolve
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public abstract class RestrictedEvolvedPokemonBase extends EvolvedPokemonBase{
    /**
     * Item to evolve
     */
    protected String evolutionStone;

    /**
     * Constructor.
     *
     * @param name of the pokemon
     * @param displayChar of the pokemon in the map
     * @param hitPoints
     * @param evolutionStone Item to evolve
     */
    public RestrictedEvolvedPokemonBase(String name, char displayChar, int hitPoints, String evolutionStone){
        super(name, displayChar, hitPoints);
        this.addCapability(Status.EVOLUTION_RESTRICTED);
        // Delete the evolveBehavior that is inherited from EvolvedPokemonBase
        deleteBehaviours(BehaviourPriority.EVOLVING);
        this.evolutionStone = evolutionStone;
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions =  super.allowableActions(otherActor, direction, map);

        for (Item item : otherActor.getInventory()){
            if (item.toString().equals(evolutionStone) && AffectionManager.getInstance().getAffectionPoint(this) == AffectionLevelPoint.MAXIMUM.getValue()){
                actions.add(new EvolveAction(this, direction, evolutionStone));
            }
        }
        return actions;
    }
}
