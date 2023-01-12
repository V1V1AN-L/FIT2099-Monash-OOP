package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.*;

import java.util.ArrayList;
import java.util.List;

public abstract class BuyAction extends Action {

    protected static final String FAILURE_MESSAGE_FORMAT = "Not enough candies - %d candies required. Ash has only %d candies.";
    protected static final String SUCCESS_MESSAGE_FORMAT = "Ash bought a %s for %d candies. Ash has only %d candies remaining.";
    protected int getTotalCandies(Actor actor){
        int totalCandies = 0;
        List<Item> inventory = actor.getInventory();
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i) instanceof Candy){
                totalCandies++;
            }
        }
        return totalCandies;
    }

    protected void removeCandiesFromInventory(Actor actor, int amount) {

        List<Item> inventory = actor.getInventory();
        List<Candy> toRemove = new ArrayList<>();
        for (Item item : inventory) {
            if (item instanceof Candy) {
                toRemove.add((Candy) item);
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
