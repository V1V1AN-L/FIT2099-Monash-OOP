package game.tools;

/**
 * Use this enum class to give `buff` or `debuff`.
 * It is also useful to give a `state` to abilities or actions that can be attached-detached.
 *
 * Created by: Riordan D. Alfredo
 *
 * @author Riordan D. Alfredo
 * Modified by: Jordan Nathanael
 */
public enum Status {
    IMMUNE, // an enum to identify that an object is immune to any attack.
    HOSTILE, // use this status to be considered hostile towards enemy (e.g., to be attacked by enemy)
    CATCHABLE,
    UNCATCHABLE,
    NONCONVERTIBLE,
    TRADEBLE,
    RUINED_RELATIONSHIP, // relationship can't be fixed (related to AffectionPoint)
    ENTERABLE
}
