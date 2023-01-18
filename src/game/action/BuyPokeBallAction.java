package game.action;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.items.Candy;
import game.items.ball.Pokeball;

public class BuyPokeBallAction extends BuyAction {

    private static final int COST = 10;

    @Override
    public String execute(Actor actor, GameMap map) {
        if(getTotalCandies(actor)>=COST){
            actor.addItemToInventory(new Pokeball());
            removeCandiesFromInventory(actor,COST);
            return String.format(SUCCESS_MESSAGE_FORMAT,"Pokeball with 1 Torchic inside",COST,getTotalCandies(actor));

        }
        return String.format(FAILURE_MESSAGE_FORMAT,COST,getTotalCandies(actor));
    }


    @Override
    public String menuDescription(Actor actor) {
        return "Buy a Pokeball with 1 Torchic ("+COST+" candies)";
    }

}
