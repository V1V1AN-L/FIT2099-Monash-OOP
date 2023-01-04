package game.pokemon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.tools.Element;
import game.weapon.BackupWeapons;

public class Treecko extends PokemonBase{
    /**
     * Constructor.
     *
     */
    public Treecko() {
        super("Treecko", 'b', 100);
        this.addCapability(Element.GRASS);
        this.favAction = FavoriteAction.DANCING;
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }

    @Override
    public void backupWeapon(){
        addItemToInventory(new BackupWeapons("Blade Cutter", ' ', 20, "whips", 90));
    }

    @Override
    public void dayEffect() {
        hurt(5);
    }

    @Override
    public void nightEffect() {
        heal(5);
    }
}
