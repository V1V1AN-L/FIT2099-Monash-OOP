package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.*;

import java.util.ArrayList;
import java.util.List;
/**
 * BuyAction abstract class which determines if player has enough candies to purchase Masterball, GreatBall or Pokeball
 * Created by: Aashlesha Gaur
 * @author Aashlesha Gaur
 */

public abstract class BuyAction extends Action {

    protected static final String FAILURE_MESSAGE_FORMAT = "Not enough candies - %d candies required. Ash has only %d candies.";
    protected static final String SUCCESS_MESSAGE_FORMAT = "Ash bought a %s for %d candies. Ash has only %d candies remaining.";
    /**
     * @return number of candies present in the inventory
     */
    protected int getTotalCandies(Actor actor){
        int totalCandies = 0;
        List<Item> inventory = actor.getInventory();
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getClass().equals(Candy.class)){
                totalCandies++;
            }
        }
        return totalCandies;
    }

    /**
     * @param actor the actor whose inventory is being accessed
     * @param amount the amount of candies to remove from inventory
     */
    protected void removeCandiesFromInventory(Actor actor, int amount) {

        List<Item> inventory = actor.getInventory();
        List<Item> toRemove = new ArrayList<>();
        for (Item item : inventory) {
            //removes candy from inventory after the transaction has already been made (after getting a ball)
            if (item.getClass().equals(Candy.class)) {
                toRemove.add(item);
                amount--;
            }
            if (amount <= 0) {
                break;
            }
        }
        for (Item item : toRemove) {
            actor.removeItemFromInventory(item);
        }
    }
}
