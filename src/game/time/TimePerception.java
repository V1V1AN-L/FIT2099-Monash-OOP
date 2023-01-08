package game.time;

/**
 * This is the interface realising method associated with the progressing of game time (number of turns)
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * Zecan Liu
 */
public interface TimePerception {
    /**
     * The default day effect which need to be implemented specifically by an instance
     */
    void dayEffect();

    /**
     * The default night effect which need to be implemented specifically by an instance
     */
    void nightEffect();

    /**
     * a default interface method that register current instance to the Singleton manager.
     * It allows corresponding class uses to be affected by global reset
     *
     */
    default void registerInstance(){
        TimePerceptionManager.getInstance().append(this);
    }
}
