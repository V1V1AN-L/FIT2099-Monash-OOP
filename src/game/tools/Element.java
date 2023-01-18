package game.tools;

/**
 * Element of the pokemon, ground
 *
 * Created by: Riordan D. Alfredo
 *
 * @author Riordan D. Alfredo
 * Modified by: Jordan Nathanael
 */
public enum Element {
    /**
     * Water element
     */
    WATER("Water"),

    /**
     * Fire element
     */
    FIRE("Fire"),

    /**
     * Grass element
     */
    GRASS("Grass"),

    /**
     * Fighting element
     */
    FIGHTING("Fighting"),

    /**
     * Ground element
     */
    GROUND("Ground"),

    /**
     * Electric element
     */
    ELECTRIC("Electric");

    /**
     * The label of the element
     */
    private final String label;

    /**
     * Constructor
     * @param label the label of the element
     */
    Element(String label){
        this.label = label;
    }

    /**
     * @return the label text
     */
    @Override
    public String toString() {
        return label;
    }
}
