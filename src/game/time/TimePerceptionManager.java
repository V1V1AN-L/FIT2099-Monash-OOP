package game.time;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Location;
import game.affection.AffectionManager;
import game.pokemon.PokemonBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A global Singleton manager that gives time perception  on the affected instances.
 * HINT: refer to Bootcamp Week 5 about static factory method.
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * Zecan Liu
 *
 */
public class TimePerceptionManager {

    /**
     * A list of polymorph instances (any classes that implements TimePerception,
     * such as, a Charmander implements TimePerception, it will be stored in here)
     */
    private List<TimePerception> timePerceptionList;

    /**
     * A counter recording the current turn of the game. This will be used to calculated the
     * game time, i.e. day or night
     */
    private int turn;

    /**
     * The indicator for game time - enum class
     */
    private TimePeriod shift; // DAY or NIGHT

    /**
     * For printing
     */
    private Display display = new Display();

    private Map<TimePeriod, String> timePeriodString = new HashMap();

    /**
     * A singleton instance
     */
    private static TimePerceptionManager instance;

    /**
     * Get or create the singleton instance of time perception manager
     *
     * @return TimePerceptionManager singleton instance
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
        timePeriodString.put(TimePeriod.DAWN,"Dawn");
        timePeriodString.put(TimePeriod.DAY,"Day");
        timePeriodString.put(TimePeriod.DUSK,"Dusk");
        timePeriodString.put(TimePeriod.NIGHT,"Night");
        timePeriodString.put(TimePeriod.MIDNIGHT,"Midnight");
        timePeriodString.put(TimePeriod.SOLARECLIPSE,"Solar eclipse");
        timePeriodString.put(TimePeriod.NEWMOON,"New moon");
    }

    /**
     * Traversing through all instances in the list and execute them
     * By doing this way, it will avoid using `instanceof` all over the place
     * The logic behind is: if turn//5 = even number, then day time, or else, night.
     * Run the specific day/night effect method for each instance.
     */
    public void run() {
        for (TimePerception each: new ArrayList<TimePerception>(this.getTimePerceptionList())){
            if (turn%7 == 0 ){
                shift = TimePeriod.DAWN;
                each.dawnEffect();

            } else if (turn%7 == 1) {
                shift = TimePeriod.DAY;
                each.dayEffect();

            } else if (turn%7 == 2) {
                shift = TimePeriod.DUSK;
                each.duskEffect();

            } else if (turn%7 == 3) {
                shift = TimePeriod.NIGHT;
                each.nightEffect();

            }else if (turn%7 == 4) {
                shift = TimePeriod.MIDNIGHT;
                each.midnightEffect();

            }
            else if (turn%7 == 5) {
                shift = TimePeriod.SOLARECLIPSE;
                each.solarEclipse();

            }
            else {
                shift = TimePeriod.NEWMOON;
                each.newMoon();
            }
        }
        display.println("It's a "+ timePeriodString.get(shift)+"-time (turn" + turn + ')');
        turn++;
    }

    /**
     * Getter
     *
     * @return timePerceptionList
     */
    public List<TimePerception> getTimePerceptionList() {
        return timePerceptionList;
    }

    /**
     * Getter
     *
     * @return turn - game turn
     */
    public int getTurn() {

        return turn;
    }

    /**
     * Setter
     *
     * @param turn The amount to update to the game turn. Should by default be 1 here
     */
    public void setTurn(int turn) {
        this.turn += turn;
    }

    /**
     * Getter
     *
     * @return shift (day or night)
     */
    public TimePeriod getShift() {
        return shift;
    }

    /**
     * Setter
     *
     * @param shift Set the game time manually by providing an input.
     */
    public void setShift(TimePeriod shift) {
        this.shift = shift;
    }

    /**
     * Add the TimePerception instance to the list
     *
     *  @param objInstance any instance that implements TimePerception
     */
    public void append(TimePerception objInstance) {
        timePerceptionList.add(objInstance);
    }


    /**
     * Remove a TimePerception instance from the list
     *
     * @param objInstance object instance
     */
    public void cleanUp(TimePerception objInstance) {
        timePerceptionList.remove(objInstance);
    }

}
