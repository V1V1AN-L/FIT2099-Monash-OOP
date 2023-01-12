package game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actors.ProfessorOak;
import game.actors.ShopKeeper;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.affection.AffectionManager;
import game.grounds.*;
import game.items.Candy;
import game.pokemon.Torchic;

/**
 * The main class to start the game.
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by: Ian K. Felix
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(),
                new Floor(), new Tree(),
                new Lava(), new Puddle(),new Crater(), new Waterfall(), new Hay());

        List<String> map = Arrays.asList(
                ".............................................^^^^^^^^^^^^^^",
                "...........,T,................................,T,..^^^^^^^^",
                ".....................................................^^^^^^",
                "........................................................^^^",
                "..........................#######........................^^",
                "..........................#_____#...........,T............^",
                "..........................#_____#..........................",
                "...........~..............###_###..........................",
                "...~~~~~~~~................................................",
                "....~~~~~.....................................C............",
                "~~~W~~~....................................................",
                "~~~~~~.,T,.................................................",
                "~~~~~~~~~..................................................");
        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        // AffectionManager
        AffectionManager am = AffectionManager.getInstance();

        //Add player - Ash
        Player ash = new Player("Ash", '@', 1);
        world.addPlayer(ash, gameMap.at(24, 6));
        am.registerTrainer(ash);

        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());
        ash.addItemToInventory(new Candy());

        //Add first pokemon - Torchic
        Actor torchic = new Torchic();
        gameMap.at(33, 10).addActor(torchic);

        Actor professorOak = ProfessorOak.getInstance();
        gameMap.at(25,7).addActor(professorOak);

        Actor shopkeeper = new ShopKeeper();
        gameMap.at(25,6).addActor(shopkeeper);

        world.run();

    }
}
