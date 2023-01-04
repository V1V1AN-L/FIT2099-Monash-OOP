package game.pokemon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapons;

public class Mudkip extends PokemonBase{
    /**
     * Constructor.
     *
     *
     */
    public Mudkip() {
        super("Mudkip", 's', 100);
        this.addCapability(Element.WATER);
        this.favAction = FavoriteAction.CHEST_POUNDING;
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }

    @Override
    public void backupWeapon(){
        addItemToInventory(new BackupWeapons("Water Blast", ' ', 25, "burbles", 80));
    }
}
