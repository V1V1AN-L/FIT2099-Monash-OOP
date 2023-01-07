package game.affection;

/**
 * Enumeration for Affection Point Level
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public enum AffectionLevelPoint {
    /**
     * It dislikes you, and the relationship cannot be fixed. It can only be captured by a Masterball.
     */
    DISLIKE(-50),

    /**
     * Neutral
     */
    NEUTRAL(0),

    /**
     * It is curious about you and is willing to be captured by a Greatball.
     */
    CURIOUS(20),

    /**
     * It likes you and is willing to be captured with Pokeball (note: not all pokemon are capturable/catchable). However, it won't follow the trainer/player yet.
     */
    WILLINGNESS(60),

    /**
     * It will follow the trainer/player around.
     */
    FOLLOWING(75),

    /**
     * The maximum affection level.
     */
    MAXIMUM(100);

    /**
     * The value of set level of each Affection Point
     */
    private final int value;

    /**
     * Constructor.
     * @param value the value of the level points
     */
    AffectionLevelPoint(int value){
        this.value = value;
    }

    /**
     * Returning the value, can be used for tier/level points indication
     * @return the value of the level points
     */
    public int getValue() {
        return value;
    }
}
