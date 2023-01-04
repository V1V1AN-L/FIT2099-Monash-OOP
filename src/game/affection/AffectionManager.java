package game.affection;

import edu.monash.fit2099.engine.actors.Actor;
import game.pokemon.PokemonBase;
import game.pokemon.Torchic;

import java.util.HashMap;
import java.util.Map;

/**
 * Affection Manager
 * <p>
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by: Ian K. Felix, Jordan Nathanael
 */
public class AffectionManager {

    /**
     * Singleton instance (the one and only for a whole game).
     */
    private static AffectionManager instance;
    /**
     * HINT: is it just for a Torchic?
     * no, changed it to accept all pokemon: Pokemonbase
     */
    private final Map<PokemonBase, Integer> affectionPoints;

    /**
     * We assume there's only one trainer in this manager.
     * Think about how will you extend it.
     *
     * each player will have their own list of pokemon which contains the AP of each pokemon.
     * Think what if the pokemon hasn't been captured, we still need to store the pokemon affection point
     * using hashmap maybe
     * [
     *  Player1: [PokemonA: 0, PokemonB:10],
     *  Player2: [PokemonC: 0, PokemonD:100],
     *  ]
     */
    private Actor trainer;

    /**
     * private singleton constructor
     */
    private AffectionManager() {
        this.affectionPoints = new HashMap<>();
    }

    /**
     * Access single instance publicly
     *
     * @return this instance
     */
    public static AffectionManager getInstance() {
        if (instance == null) {
            instance = new AffectionManager();
        }
        return instance;
    }

    /**
     * Add a trainer to this class's attribute. Assume there's only one trainer at a time.
     *
     * @param trainer the actor instance
     */
    public void registerTrainer(Actor trainer) {
        this.trainer = trainer;
    }

    /**
     * Add Pokemon to the collection. By default, it has 0 affection point. Ideally, you'll register all instantiated Pokemon
     *
     * @param pokemon
     */
    public void registerPokemon(PokemonBase pokemon) {
        affectionPoints.put(pokemon, 0);
    }

    /**
     * Get the affection point by using the pokemon instance as the key.
     *
     * @param pokemon Pokemon instance
     * @return integer of affection point.
     */
    public int getAffectionPoint(PokemonBase pokemon) {
        return affectionPoints.get(pokemon);
    }

    /**
     * Useful method to search a pokemon by using Actor instance.
     *
     * @param actor general actor instance
     * @return the Pokemon instance.
     */
    private PokemonBase findPokemon(Actor actor) {
        for (PokemonBase pokemon : affectionPoints.keySet()) {
            if (pokemon.equals(actor)) {
                return pokemon;
            }
        }
        return null;
    }

    /**
     * Increase the affection. Work on both cases when there's a Pokemon,
     * or when it doesn't exist in the collection.
     *
     * @param actor Actor instance, but we expect a Pokemon here.
     * @param point positive affection modifier
     * @return custom message to be printed by Display instance later.
     */
    public String increaseAffection(Actor actor, int point) {
        PokemonBase pokemon = findPokemon(actor);
        affectionPoints.put(pokemon, getAffectionPoint(pokemon)+point);

        // if AP is >= 75, add followBehavior for the pokemon
        if (getAffectionPoint(pokemon) >= 75){
            pokemon.addFollowBehaviours(trainer);
        }

        return pokemon.toString() + "'s affection point is increased by " + Integer.toString(point);
    }

    /**
     * Decrease the affection level of the . Work on both cases when it is
     *
     * @param actor Actor instance, but we expect a Pokemon here.
     * @param point positive affection modifier (to be subtracted later)
     * @return custom message to be printed by Display instance later.
     */
    public String decreaseAffection(Actor actor, int point) {
        PokemonBase pokemon = findPokemon(actor);
        affectionPoints.put(pokemon, getAffectionPoint(pokemon)-point);

        if (getAffectionPoint(pokemon) < 75){
            pokemon.deleteFollowBehaviours();
        }

        return pokemon.toString() + "'s affection point is decreased by " + Integer.toString(point);
    }

}
