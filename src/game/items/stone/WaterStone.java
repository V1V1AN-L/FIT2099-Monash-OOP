package game.items.stone;

/**
 * Abstract class for Evolution Stone
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public class WaterStone extends Stone{
    /**
     * static name, used for identification in each pokemon that need this item
     * so instead of type WaterStone everytime need this for the new pokemon,
     * just use the static variable to avoid mistyping the name.
     */
    public static final String NAME = "WaterStone";

    /**
     * Constructor.
     */
    public WaterStone(){
        super(WaterStone.NAME, '{', true);
    }
}
