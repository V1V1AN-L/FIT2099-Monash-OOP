package game.items.Ball;

import edu.monash.fit2099.engine.actors.Actor;
import game.affection.AffectionLevelPoint;
import game.items.Ball.GeneralBall;

/**
 * Pokeball can be used to be capture pokemon
 * Created by: Zecan (Vivian) Liu
 *
 * @author zliu0207
 * Modified by: Jordan Nathanael
 */
public class Pokeball extends GeneralBall {
    /***
     * Constructor.
     */
    public Pokeball() {
        super("Pokeball", 'o', true);
    }

    @Override
    public boolean checkAffectionPointReq(Actor storedPokemon, int affectionPoint) throws Exception
    {
        if (affectionPoint >= AffectionLevelPoint.WILLINGNESS.getValue()){
            return super.checkAffectionPointReq(storedPokemon, affectionPoint);
        }
        return false;
    }
}
