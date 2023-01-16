package game.items.WeaponEffect;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;

public abstract class WeaponEffectItem extends Item {
    protected int duration;

    protected WeaponEffectItem(String name, char displayChar, int duration){
        super(name, displayChar, false);
        this.duration = duration;
    }

    protected void cleanUp(Location loc){
        if (duration <= 0){
            loc.removeItem(this);
        }
        duration -= 1;
    }
}
