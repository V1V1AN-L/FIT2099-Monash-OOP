package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.items.GeneralBall;
import game.time.TimePerceptionManager;
import game.tools.Status;

import java.util.ArrayList;

/**
 * Class representing the Player.
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Player extends Actor {

	private final Menu menu = new Menu();
	public static ArrayList<GeneralBall> pokeballsBag = new ArrayList<>();

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
//		Clock clock = new Clock();
//		addItemToInventory(clock);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		TimePerceptionManager.getInstance().run();

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public char getDisplayChar() {
		return super.getDisplayChar();
	}

	public ArrayList<GeneralBall> getPokeballsBag() {
		return pokeballsBag;
	}

	public void setPokeballsBag(GeneralBall pokeball) {
		this.pokeballsBag.add(pokeball);
	}
}
