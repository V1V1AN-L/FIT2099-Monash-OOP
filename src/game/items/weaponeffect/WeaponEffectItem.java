package game.items.weaponeffect;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Abstract class of WeaponEffectItem
 *
 * Created by: Jordan Nathanael
 * @author jordannathanael
 */
public abstract class WeaponEffectItem extends Item {
    /**
     * Duration of the weaponEffect
     */
    protected int duration;

    /**
     * Constructor
     *
     * @param name of the weaponEffect
     * @param displayChar that will be showed in the gameMap
     * @param duration of the weaponEffect
     */
    protected WeaponEffectItem(String name, char displayChar, int duration){
        super(name, displayChar, false);
        this.duration = duration;
    }

    /**
     * Remove this weaponEffect from GameMap once the duration is done
     *
     * @param loc
     */
    protected void cleanUp(Location loc){
        if (duration <= 0){
            loc.removeItem(this);
        }
        duration -= 1;
    }
}
