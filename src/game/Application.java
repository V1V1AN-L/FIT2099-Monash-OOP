package game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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
                "............T,.................................T,..^^^^^^^^",
                ".....................................................^^^^^^",
                "........................................................^^^",
                ".........................................................^^",
                "............................###..............T,...........^",
                "..................,T........#.#............................",
                "...T.......~...............................................",
                "...~~~~~~~~................................................",
                "....~~~~~.....................................C............",
                "~~~W~~~....................................................",
                "~~~~~~..T..............................T...................",
                "~~~~~~~~~..................................................");

        List<String> pokeCenter = Arrays.asList(
                "##################",
                "#________________#",
                "#______....._____#",
                "#________________#",
                "#________________#",
                "#######_._########");

        GameMap gameMap = new GameMap(groundFactory, map);
        GameMap pokeCenterMap = new GameMap(groundFactory, pokeCenter);

        world.addGameMap(pokeCenterMap);
        world.addGameMap(gameMap);

        // AffectionManager
        AffectionManager am = AffectionManager.getInstance();

        //Add player - Ash
        Player ash = new Player("Ash", '@', 1);
        world.addPlayer(ash, gameMap.at(32, 10));
        am.registerTrainer(ash);

        IntStream.range(0, 20).forEach(i -> ash.addItemToInventory(new Candy()));

        //Add first pokemon - Torchic
        Actor torchic = new Torchic();
        gameMap.at(33, 10).addActor(torchic);

        Actor professorOak = ProfessorOak.getInstance();
        gameMap.at(25,7).addActor(professorOak);

        Actor shopkeeper = new ShopKeeper();
        gameMap.at(25,6).addActor(shopkeeper);

        gameMap.at(29,6).setGround(new Door(pokeCenterMap.at(8,5)));
        pokeCenterMap.at(8,5).setGround(new Door(gameMap.at(29,6)));

        world.run();

    }
}
