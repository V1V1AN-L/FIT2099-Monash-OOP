package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.items.ball.GeneralBall;
import game.pokemon.PokemonBase;

/**
 * An action to summon PokemonBase
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class SummonAction extends Action {
    /**
     * The actor that want to be summoned
     */
    private GeneralBall ball;

    /**
     * Constructor.
     *
     * @param ball The ball that contains a pokemon
     */
    public SummonAction(GeneralBall ball){
        this.ball = ball;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        PokemonBase summoned = this.ball.getStoredPokemon();
        String result = actor + " summoned " + summoned.toString();

        // check surrounding to get the position to summon the pokemon
        for (Exit exit : map.locationOf(actor).getExits()){
            Location summonLoc = exit.getDestination();

            if (summonLoc.canActorEnter(actor)){
                this.ball.setStoredPokemonNull();
                map.addActor(summoned, summonLoc);
                result += " is successful.";
                return result;
            }
        }
        result += " is failed because there isn't any available space to summon the pokemon.";
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " summons " + this.ball.getStoredPokemon();
    }
}
