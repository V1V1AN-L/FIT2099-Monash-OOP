package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.items.Item;
import game.action.BuyGreatBallAction;
import game.action.BuyMasterBallAction;
import game.action.BuyPokeBallAction;
import game.action.EndGameAction;
import game.items.*;
import game.pokemon.Torchic;

import java.util.ArrayList;
import java.util.List;

/**
 *  ShopKeeper , singleton class that interacts with the Player and is part of the BuyGreatBallAction, BuyMasterBallAction and BuyPokeBallAction.
 * Created by: Aashlesha Gaur
 * @author Aashlesha Gaur
 */
public class ShopKeeper extends Actor {
    

    private static final char DEFAULT_DISPLAY_CHAR = '%';
    private static final String DEFAULT_NAME = "Shopkeeper";
    private static ShopKeeper shopKeeper;

    @Override
    public void addItemToInventory(Item item ) {
        super.addItemToInventory(item);
    }

    public ShopKeeper() {
        super(DEFAULT_NAME,DEFAULT_DISPLAY_CHAR, 0);
    }

    //Singleton
    public static ShopKeeper getInstance(){
        if(shopKeeper == null){
            shopKeeper = new ShopKeeper();
        }
        return shopKeeper;
    }


    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList result = super.allowableActions(otherActor,direction,map);
        result.add(new BuyGreatBallAction());
        result.add(new BuyMasterBallAction());
        result.add(new BuyPokeBallAction());
        return result;
    }

}
