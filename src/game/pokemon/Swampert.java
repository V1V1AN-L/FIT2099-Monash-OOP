package game.pokemon;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.WeaponEffect.Flood;
import game.tools.Element;
import game.weapon.BackupWeapons;
import game.weapon.UniqueWeaponSkill;

import java.util.ArrayList;

/**
 *
 * Created by: Jordan Nathanael
 *
 * @author jordannathanael
 */
public class Swampert extends PokemonBase implements UniqueWeaponSkill {
    private final int SURF_DURATION = 3;

    /**
     * Constructor.
     */
    public Swampert(ArrayList<BackupWeapons> oldBackupWeapons) {
        super("Swampert", 'N', 250);
        this.addCapability(Element.WATER);
        this.addCapability(Element.GROUND);
        this.favAction = FavoriteAction.SINGING;

        for (BackupWeapons backupWeapon : oldBackupWeapons){
            this.backupWeapons.add(backupWeapon);
        }
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }

    @Override
    protected BackupWeapons backupWeapon(){
        BackupWeapons weapon = new BackupWeapons("Surf", ' ', 80, "tornadoes", 95, Element.WATER, true);
        weapon.setUniqueWeaponSkill(this::weaponEffect);
        return weapon;
    }

    public void weaponEffect(Actor actor, GameMap map) {
        // check surrounding
        for (Exit exit : map.locationOf(actor).getExits()) {
            for (Exit exit2 : exit.getDestination().getExits()){
                if (exit2.getDestination().getGround().canActorEnter(exit2.getDestination().getActor())){
                    Location targetLoc = exit2.getDestination();

                    targetLoc.addItem(new Flood(SURF_DURATION));
                }
            }
        }
    }

}
