package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.time.TimePerception;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Lava extends ConvertibleGrounds {
//    private List<Exit> availableExits = new ArrayList<Exit>();
//    private Location location;


    /**
     * Constructor.
     */
    public Lava() {
        super('^', Element.FIRE);
        this.addCapability(element);
        registerInstance();

    }

//    @Override
//    public void tick(Location location) {
//        super.tick(location);
//        this.location = location;
//        availableExits = location.getExits();
//    }

    @Override
    public void dayEffect() {
        int randomNum = new Random().nextInt(9);
        if (randomNum == 0){
            Lava lava = new Lava();
            expandGround(lava);
        }
    }

    @Override
    public void nightEffect() {
        int randomNum = new Random().nextInt(9);
        if (randomNum == 0){
            destroyGround();
        }
    }


//    @Override
//    public void registerInstance() {
//        TimePerception.super.registerInstance();
//    }

//    public List<Exit> getAvailableExits() {
//        return availableExits;
//    }
//
//    public void setAvailableExits(List<Exit> availableExits) {
//        this.availableExits = availableExits;
//    }
}
