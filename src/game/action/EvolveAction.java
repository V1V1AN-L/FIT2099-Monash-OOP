package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.affection.AffectionManager;
import game.items.stone.Stone;
import game.pokemon.EvolvedPokemonBase;
import game.pokemon.PokemonBase;

/**
 * An Action to evolve Pokemon
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class EvolveAction extends Action {
    /**
     * Evolution Stone (Optional)
     */
    private String evolutionStone;

    /**
     * The Actor that wants to evolve
     */
    private EvolvedPokemonBase target;

    /**
     * The direction of incoming evolve manual
     */
    private String direction;


    /**
     * Constructor.
     *
     * @param target the pokemon that want to be evolved
     * @param direction the direction of pokemon that need help to evolve
     */
    public EvolveAction(EvolvedPokemonBase target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Constructor for restrictedEvolvedPokemonBase
     *
     * @param target the pokemon that want to be evolved
     * @param direction the direction of pokemon that need help to evolve
     * @param evolutionStone the stone that need to be used for the evolution
     */
    public EvolveAction(EvolvedPokemonBase target, String direction, String evolutionStone){
        this.target = target;
        this.direction = direction;
        this.evolutionStone = evolutionStone;
    }
    
    @Override
    public String execute(Actor actor, GameMap map) {
        PokemonBase evolvedPokemon = target.evolve();

        // use this affectionPoint for modify the evolved version
        // if its original AP is 10, so after it evolves itself, its ap also becomes 10
        int affectionPoint = AffectionManager.getInstance().getAffectionPoint(target);

        AffectionManager.getInstance().unregisterPokemon(target);
        AffectionManager.getInstance().modifyAffection(evolvedPokemon, affectionPoint);

        //replace the old pokemon with the evolved in the map
        Location evolutionLoc = map.locationOf(target);
        map.removeActor(target);
        map.addActor(evolvedPokemon, evolutionLoc);

        //remove evolutionStone from player inventory
        if (evolutionStone != null){
            for (Item item : actor.getInventory()){
                if (item.toString().equals(evolutionStone)){
                    actor.removeItemFromInventory(item);
                    break;
                }
            }
        }

        return "Evolution is successful. " + target + " evolves into " + evolvedPokemon;
    }

    @Override
    public String menuDescription(Actor actor) {
        String output = actor + " helps " + target + " at " + direction + " to evolve";
        if (evolutionStone != null){
            return output + " using " + evolutionStone;
        }
        return output;
    }
}
