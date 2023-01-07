package game.tools;

/**
 * Element of the pokemon, ground
 *
 * Created by: Riordan D. Alfredo
 *
 * @author Riordan D. Alfredo
 * Modified by:
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
    GRASS("Grass");

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
