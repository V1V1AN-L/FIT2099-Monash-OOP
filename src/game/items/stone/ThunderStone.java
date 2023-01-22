package game.items.stone;

/**
 * Abstract class for Evolution Stone
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public class ThunderStone extends Stone{
    /**
     * static name, used for identification in each pokemon that need this item
     * so instead of type ThunderStone everytime need this for the new pokemon,
     * just use the static variable to avoid mistyping the name.
     */
    public static final String NAME = "ThunderStone";

    /**
     * Constructor
     */
    public ThunderStone() {
        super(ThunderStone.NAME, '}', true);
    }
}
