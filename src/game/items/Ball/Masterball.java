package game.items.Ball;

import edu.monash.fit2099.engine.actors.Actor;
import game.affection.AffectionLevelPoint;
import game.affection.AffectionManager;
import game.items.Ball.GeneralBall;
import game.tools.Status;

/**
 * Masterball can be used to be capture pokemon
 * Created by: Zecan (Vivian) Liu
 *
 * @author zliu0207
 * Modified by: Jordan Nathanael
 */
public class Masterball extends GeneralBall {
    /***
     * Constructor.
     */
    public Masterball() {
        super("Masterball", '0', true);
    }

    @Override
    public boolean checkAffectionPointReq(Actor storedPokemon, int affectionPoint) throws Exception
    {
        // set AffectionPoint into 100 instantly
        AffectionManager.getInstance().modifyAffection(storedPokemon, AffectionLevelPoint.MAXIMUM.getValue());

        // remove capabilities of RUINED_RELATIONSHIP
        if (AffectionManager.getInstance().findPokemon(storedPokemon).hasCapability(Status.RUINED_RELATIONSHIP)){
            AffectionManager.getInstance().findPokemon(storedPokemon).removeCapability(Status.RUINED_RELATIONSHIP);
        }

        return super.checkAffectionPointReq(storedPokemon, affectionPoint);
    }
}
