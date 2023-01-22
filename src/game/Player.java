package game;

import edu.monash.fit2099.engine.actions.*;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.affection.AffectionManager;
import game.items.Candy;
<<<<<<< HEAD
import game.items.Greatball;
import game.items.Masterball;
import game.items.PokeLocator;
=======
import game.items.ball.Greatball;
import game.items.ball.Masterball;
import game.items.stone.ThunderStone;
import game.items.stone.WaterStone;
import game.time.TimePerception;
>>>>>>> 8175533648c35925ce7cc2fa018c22ca5b406c7d
import game.time.TimePerceptionManager;
import game.tools.Status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Class representing the Player.
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * Zecan Liu & Jordan Nathanael
 *
 */
public class Player extends Actor {

	private final Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.IMMUNE);
		this.addCapability(Status.ENTERABLE);

		AffectionManager.getInstance().registerTrainer(this);

		addItemToInventory(new Masterball());
		addItemToInventory(new Greatball());
<<<<<<< HEAD
		addItemToInventory(new PokeLocator());
=======
		addItemToInventory(new ThunderStone());
		addItemToInventory(new WaterStone());
>>>>>>> 8175533648c35925ce7cc2fa018c22ca5b406c7d
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

		// TimePerceptionManager runs here
		TimePerceptionManager.getInstance().run();

		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public char getDisplayChar() {
		return super.getDisplayChar();
	}
}
