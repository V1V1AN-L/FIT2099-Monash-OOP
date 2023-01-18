package game.action;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.ball.Masterball;

public class BuyMasterBallAction extends BuyAction{

    private static final int COST = 6;

    @Override
    public String execute(Actor actor, GameMap map) {
        if(getTotalCandies(actor)>=COST){
            actor.addItemToInventory(new Masterball());
            removeCandiesFromInventory(actor,COST);
            return String.format(SUCCESS_MESSAGE_FORMAT,"Masterball",COST,getTotalCandies(actor));
        }
        return String.format(FAILURE_MESSAGE_FORMAT,COST,getTotalCandies(actor));
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Buy a Masterball ("+COST+" candies)";
    }

}
