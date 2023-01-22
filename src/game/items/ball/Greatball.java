package game.items.ball;

import edu.monash.fit2099.engine.actors.Actor;
import game.affection.AffectionLevelPoint;

/**
 * Greatball can be used to be capture pokemon
 * Created by: Zecan (Vivian) Liu
 *
 * @author zliu0207
 * Modified by: Jordan Nathanael
 */
public class Greatball extends GeneralBall {

    /***
     * Constructor.
     */
    public Greatball() {
        super("Greatball", 'O', true);
    }

    @Override
    public boolean checkAffectionPointReq(Actor storedPokemon, int affectionPoint) throws Exception
    {
        if (affectionPoint >= AffectionLevelPoint.CURIOUS.getValue()){
            return super.checkAffectionPointReq(storedPokemon, affectionPoint);
        }
        return false;
    }
}
