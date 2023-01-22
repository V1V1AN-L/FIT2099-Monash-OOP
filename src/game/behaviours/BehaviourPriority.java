package game.behaviours;

/**
 * Enumeration of Behavior Priority
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public enum BehaviourPriority {
    /**
     * Evolve the pokemon whenever it is possible
     */
    EVOLVING(0),

    /**
     * Everytime pokemon changes its location, check the condition to toggle the weapon
     */
    TOGGLING(1),

    /**
     * Attacks is the main priority after having the weapon from toggleBehavior
     */
    ATTACKING(2),

    /**
     * Follow the trainer is more prioritized than wandering.
     */
    FOLLOWING(3),

    /**
     * Wander around the map is the last option if there is no other behavior possible within the turn
     */
    WANDERING(4);

    /**
     * The Priority value ( closer to 0 is what will be done )
     */
    private final int value;

    /**
     * Constructor.
     *
     * @param value the key priority value
     */
    BehaviourPriority(int value){
        this.value = value;
    }

    /**
     * Return its priority key value
     *
     * @return the value of priority
     */
    public int getValue() {
        return value;
    }
}
