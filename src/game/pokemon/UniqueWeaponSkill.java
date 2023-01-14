package game.pokemon;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * https://stackoverflow.com/questions/29219984/can-i-store-a-method-in-a-variable-in-java-8
 */
@FunctionalInterface
public interface UniqueWeaponSkill {
    void weaponEffect(Actor actor, GameMap map);
}
