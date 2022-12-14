package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.time.TimePerception;

import java.util.ArrayList;
import java.util.List;

public abstract class ConvertibleGrounds extends Ground implements TimePerception {

    protected List<Exit> availableExits = new ArrayList<Exit>();

    protected Location location;

    protected Element element;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public ConvertibleGrounds(char displayChar, Element element) {
        super(displayChar);
        this.element = element;
        registerInstance();
    }

    public void tick(Location location) {
        super.tick(location);
        this.location = location;
        availableExits = location.getExits();
    }


    protected void expandGround(Ground ground){
        for(Exit exit: availableExits){
            if(!(exit.getDestination().getGround() instanceof NonCovertibleGround)
                    && !(exit.getDestination().getGround().hasCapability(element))){
                exit.getDestination().setGround(ground);
            }
        }

    }

    protected void destroyGround(){
        this.location.setGround(new Dirt());
    }

    public List<Exit> getAvailableExits() {
        return availableExits;
    }

    public void setAvailableExits(List<Exit> availableExits) {
        this.availableExits = availableExits;
    }

}
