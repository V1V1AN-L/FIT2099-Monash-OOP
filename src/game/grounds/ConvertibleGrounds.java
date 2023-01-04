package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.tools.Element;
import game.time.TimePerception;

import java.util.ArrayList;
import java.util.List;

public abstract class ConvertibleGrounds extends Ground implements TimePerception{

    protected List<Exit> availableExits = new ArrayList<Exit>();

    protected Location location;

    protected Element element;



    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public ConvertibleGrounds(char displayChar) {
        super(displayChar);
        registerInstance();
    }

//    public void tick(Location location) {
//        super.tick(location);
//        updateTickCount(1);
//        this.location = location;
//        if (getTickCount() != 0) {
//            availableExits = location.getExits();
//        }
//    }



    protected void expandGround(Ground ground){
        for(Exit exit: availableExits){
            if(!(exit.getDestination().getGround() instanceof NonConvertibleGround)
                    && !(exit.getDestination().getGround().hasCapability(element))){
                exit.getDestination().setGround(ground);

            }
        }
    }

    protected void destroyGround(){
        System.out.println(location.x()+"x");
        System.out.println(location.y()+"y");
        if (!location.containsAnActor()){
            System.out.println("up to here");
            location.setGround(new Dirt());
        }
    }

    public List<Exit> getAvailableExits() {
        return availableExits;
    }

    public void setAvailableExits(List<Exit> availableExits) {
        this.availableExits = availableExits;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
