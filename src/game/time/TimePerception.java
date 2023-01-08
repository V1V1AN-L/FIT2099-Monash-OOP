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
     * TODO: Use this method at the constructor of the concrete class that implements it (`this` instance).
     *       For example:
     *       Simple(){
     *          // other stuff for constructors.
     *          this.registerInstance()  // add this instance to the relevant manager.
     *       }
     */
    default void registerInstance(){
        TimePerceptionManager.getInstance().append(this);
    }
}
