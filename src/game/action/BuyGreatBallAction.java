package game.action;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Masterball;

public class BuyGreatBallAction extends BuyAction{

    private static final int COST = 3;

    @Override
    public String execute(Actor actor, GameMap map) {
        if(getTotalCandies(actor)>=COST){
            actor.addItemToInventory(new Masterball());
            removeCandiesFromInventory(actor,COST);
            return String.format(SUCCESS_MESSAGE_FORMAT,"Greatball",COST,getTotalCandies(actor));
        }
        return String.format(FAILURE_MESSAGE_FORMAT,COST,getTotalCandies(actor));
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Buy a Greatball ("+COST+" candies)";
    }

}
