package game.weapon;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.AttackAction;
import game.affection.AffectionManager;
import game.pokemon.PokemonBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Special weapon that will be stored as an attribute for each pokemon
 * Created by: Riordan D. Alfredo
 * @author Riordan D. Alfredo
 * Modified by: Jordan Nathanael
 *
 * @see Actor#getWeapon() method.
 * @see AttackAction uses getWeapon() in the execute() method.
 */
public class BackupWeapons extends WeaponItem{
    // Use this class to store the backupWeapons
    public BackupWeapons(String name, char displayChar, int damage, String verb, int hitRate){
        super(name, displayChar, damage, verb, hitRate);
    }
}
