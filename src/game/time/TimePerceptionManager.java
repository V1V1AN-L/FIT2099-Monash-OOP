package game.time;

import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * A global Singleton manager that gives time perception  on the affected instances.
 * TODO: you may modify (add or remove) methods in this class if you think they are not necessary.
 * HINT: refer to Bootcamp Week 5 about static factory method.
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class TimePerceptionManager {


    /**
     * A list of polymorph instances (any classes that implements TimePerception,
     * such as, a Charmander implements TimePerception, it will be stored in here)
     */
    private final List<TimePerception> timePerceptionList;

    private int turn;

    private TimePeriod shift; // DAY or NIGHT

    /**
     * A singleton instance
     */
    private static TimePerceptionManager instance;

    /**
     * Get the singleton instance of time perception manager
     *
     * @return TimePerceptionManager singleton instance
     *
     * FIXME: create a singleton instance.
     */
    public static TimePerceptionManager getInstance(){
        if (instance == null){
            instance = new TimePerceptionManager();
        }
        return instance;
    }


    /**
     * Private constructor
     */
    private TimePerceptionManager() {
        timePerceptionList = new ArrayList<>();
        turn = 0;
    }

    /**
     * Traversing through all instances in the list and execute them
     * By doing this way, it will avoid using `instanceof` all over the place.
     *
     * if turn//5 = even number, then it should be day time. If it's odd number, then it should be night time.
     */
    public void run() {
        for (TimePerception each: new ArrayList<TimePerception>(this.getTimePerceptionList())){
            if ((turn/5) % 2 == 0){
                shift = TimePeriod.DAY;
                each.dayEffect();
            }else{
                each.nightEffect();
                shift = TimePeriod.NIGHT;
            }
        }
        turn++;

        if (shift == TimePeriod.DAY) {
            System.out.println("It's a Day-time (turn" + turn + ')');
        }else{
            System.out.println("It's a Night-time (turn" + turn + ')');
        }
    }


    public List<TimePerception> getTimePerceptionList() {
        return timePerceptionList;
    }
    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn += turn;
    }

    public TimePeriod getShift() {
        return shift;
    }

    public void setShift(TimePeriod shift) {
        this.shift = shift;
    }


    /**
     * Add the TimePerception instance to the list
     * FIXME: add objInstance to the list.
     * @param objInstance any instance that implements TimePerception
     */
    public void append(TimePerception objInstance) {
        timePerceptionList.add(objInstance);
    }


    /**
     * Remove a TimePerception instance from the list
     *
     * FIXME: [OPTIONAL] run cleanUp once every turn if you don't want to
     *        have too many instances in the list (e.g., memory leak)
     * @param objInstance object instance
     */
    public void cleanUp(TimePerception objInstance) {
    }

}
