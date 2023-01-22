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
import game.pokemon.Eevee;
import game.pokemon.Pikachu;
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
                new Floor(), new Tree(), new ElectricField(),
                new Lava(), new Puddle(),new Crater(), new Waterfall(), new Hay());

        List<String> map = Arrays.asList(
                ".............................................^^^^^^^^^^^^^^",
                ".C..........T,.................................T,..^^^^^^^^",
                ".....................................................^^^^^^",
                "................................E.......................^^^",
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
        world.addPlayer(ash, gameMap.at(26, 8));
        am.registerTrainer(ash);

        Actor eevee = new Eevee();
        gameMap.at(25, 9).addActor(eevee);
        AffectionManager.getInstance().modifyAffection(eevee, 100);

        //Add first pokemon - Pikachu
        Actor pikachu = new Pikachu();
        gameMap.at(26, 9).addActor(pikachu);
        AffectionManager.getInstance().modifyAffection(pikachu, 100);

        //Add torchic
        Actor torchic = new Torchic();
        gameMap.at(26, 7).addActor(torchic);
        AffectionManager.getInstance().modifyAffection(torchic, 100);

        Actor professorOak = ProfessorOak.getInstance();
        gameMap.at(25,7).addActor(professorOak);

        Actor shopkeeper = new ShopKeeper();
        pokeCenterMap.at(9,2).addActor(shopkeeper);

        gameMap.at(29,6).setGround(new Door(pokeCenterMap.at(8,5)));
        pokeCenterMap.at(8,5).setGround(new Door(gameMap.at(29,6)));

        world.run();

    }
}
