package game.weapon;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.AttackAction;
import game.tools.Element;

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
    private boolean specialEffect;

    public UniqueWeaponSkill uniqueWeaponSkill;

    /**
     * Constructor
     *
     * @param name        of the weapon
     * @param displayChar
     * @param damage
     * @param verb
     * @param hitRate
     */
    public BackupWeapons(String name, char displayChar, int damage, String verb, int hitRate, Element element, boolean specialEffect){
        super(name, displayChar, damage, verb, hitRate);
        this.specialEffect = specialEffect;
        this.addCapability(element);
    }

    public boolean hasSpecialEffect(){
        return specialEffect;
    }

    public void setUniqueWeaponSkill(UniqueWeaponSkill skill){
        uniqueWeaponSkill = skill;
    }

}
