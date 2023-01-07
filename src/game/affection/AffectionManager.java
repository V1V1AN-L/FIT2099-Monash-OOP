package game.affection;

import edu.monash.fit2099.engine.actors.Actor;
import game.pokemon.PokemonBase;
import game.tools.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * Affection Manager
 * <p>
 * Created by: Riordan D. Alfredo
 *
 * @author Riordan D. Alfredo
 * Modified by: Ian K. Felix, Jordan Nathanael
 */
public class AffectionManager {
    /**
     * Fixed value when create PokemonBase is instantiated
     */
    public static final int DEFAULT_AFFECTION_POINT = 0;

    /**
     * Singleton instance (the one and only for a whole game).
     */
    private static AffectionManager instance;

    /**
     * The Container to contain the PokemonBase and its own affection Point
     */
    private final Map<PokemonBase, Integer> affectionPoints;

    /**
     * The Player inside the game.
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
        affectionPoints.put(pokemon, AffectionManager.DEFAULT_AFFECTION_POINT);
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
    public PokemonBase findPokemon(Actor actor) {
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

        // if AP exceed the Maximum value, assign it as max
        if (getAffectionPoint(pokemon) > AffectionLevelPoint.MAXIMUM.getValue()){
            setStaticAffection(pokemon, AffectionLevelPoint.MAXIMUM.getValue());
        }

        // if AP is >= 75, add followBehavior for the pokemon
        if (getAffectionPoint(pokemon) >= AffectionLevelPoint.FOLLOWING.getValue()){
            pokemon.addFollowBehaviours(trainer);
        }

        return pokemon + "'s affection point is increased by " + Integer.toString(point);
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

        if (getAffectionPoint(pokemon) < AffectionLevelPoint.FOLLOWING.getValue()){
            pokemon.deleteFollowBehaviours();
        }

        if (getAffectionPoint(pokemon) <= AffectionLevelPoint.DISLIKE.getValue()){
            pokemon.addCapability(Status.RUINED_RELATIONSHIP);
        }

        return pokemon.toString() + "'s affection point is decreased by " + Integer.toString(point);
    }

    /**
     * Used when we capture a pokemon by Masterball, set the affection point directly to 100
     *
     * @param actor the target PokemonBase that the affection point will be changed
     * @param point set its affection point as similar as the point
     */
    public void setStaticAffection(Actor actor, int point){
        PokemonBase pokemon = findPokemon(actor);
        affectionPoints.put(pokemon, point);
    }

}
