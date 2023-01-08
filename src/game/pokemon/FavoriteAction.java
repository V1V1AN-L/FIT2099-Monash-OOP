package game.pokemon;

/**
 * Enumeration of Favorite Action
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public enum FavoriteAction {
    /**
     * Singing action
     */
    SINGING("singing"),

    /**
     * Dancing action
     */
    DANCING("dancing"),

    /**
     * Chest Pounding Action
     */
    CHEST_POUNDING("chest pounding");

    /**
     * it is used as noun in the menu description
     */
    private final String label;

    /**
     * Constructor.
     *
     * @param label the noun for each enum
     */
    FavoriteAction(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
