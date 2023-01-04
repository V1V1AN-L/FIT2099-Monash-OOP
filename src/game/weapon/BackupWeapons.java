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
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Jordan Nathanael
 *
 * TODO: Use this class to store Pokemon's weapons (special attack) permanently.
 * If a Pokemon needs to use a weapon, put it into that Pokemon's inventory.
 * @see Actor#getWeapon() method.
 * @see AttackAction uses getWeapon() in the execute() method.
 */
public class BackupWeapons{
    // Use this class to store the backupWeapons
    private static Map<PokemonBase, SpecialWeapons> backupWeapons = new HashMap<>();

    public static void addBackupWeapons(PokemonBase pokemon, SpecialWeapons specialWeapons){
        backupWeapons.put(pokemon, specialWeapons);
    }
    
    public static SpecialWeapons getBackupWeapons(PokemonBase pokemon){
        return backupWeapons.get(pokemon);
    }
}
