package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.time.TimePerceptionManager;
import game.time.TimePeriod;

public class Clock extends Item {
    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */

    private TimePerceptionManager timeManager;
    public Clock() {
        super("Clock", ' ', false);
        timeManager = TimePerceptionManager.getInstance();
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        timeManager.run();
        timeManager.setTurn(1);
        System.out.println(timeManager.getShift());
        if (timeManager.getShift()== TimePeriod.DAY) {
            System.out.println("It's a Day-time (turn" + timeManager.getTurn() + ')');
        }else{
            System.out.println("It's a Night-time (turn" + timeManager.getTurn() + ')');

        }
    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        timeManager.run();
        timeManager.setTurn(1);
        System.out.println(timeManager.getShift());
        if (timeManager.getShift()== TimePeriod.DAY) {
            System.out.println("It's a Day-time (turn" + timeManager.getTurn() + ')');
        }else{
            System.out.println("It's a Night-time (turn" + timeManager.getTurn() + ')');

        }
    }
}
