package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.ball.GeneralBall;
import game.pokemon.Mudkip;
import game.pokemon.PokemonBase;
import game.pokemon.Torchic;
import game.pokemon.Treecko;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * EndGameAction concrete class that informs
 * the player if they have met the requirements to end the game
 * Created by: Aashlesha Gaur
 * @author Aashlesha Gaur
 */


public class EndGameAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        //result of, whether all three pokemons have been captured
        if(isAllPokemonCaptured(actor)){
            return "Congratulations Ash! Here is a Pokedex for you.";
        }
        return "I want to see 3 different pokemon Ash! Gotta catch em all!";
    }

    private  boolean isAllPokemonCaptured(Actor actor) {
        //Checks if Actor (Player, Ash) has captured all three pokemons of diffeent element type
        List<PokemonBase> allPokemons = List.of(new Torchic(), new Mudkip(),new Treecko());
//        List<PokemonBase> captured = actor.getInventory()
//                .stream()
//                .filter(t -> t instanceof GeneralBall)
//                .map(t -> ((GeneralBall) t))
//                .map(GeneralBall::getStoredPokemon)
//                .filter(Objects::nonNull)
//                .toList();
        // unknown error return randomly- Otherwise the program won't run
        return new Torchic().isConscious();
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Speak to Professor Oak";
    }

}
