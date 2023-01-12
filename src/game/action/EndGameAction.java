package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.pokemon.Mudkip;
import game.pokemon.PokemonBase;
import game.pokemon.Torchic;
import game.pokemon.Treecko;

import java.util.List;
import java.util.Set;

public class EndGameAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        if(isAllPokemonCaptured(actor)){
            return "Congratulations Ash! Here is a Pokedex for you.";
        }
        return "I want to see 3 different pokemon Ash! Gotta catch em all!";
    }

    private boolean isAllPokemonCaptured(Actor actor) {
        List<PokemonBase> allPokemons = List.of(new Torchic(), new Mudkip(),new Treecko());
        return actor.getInventory().containsAll(allPokemons);
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Speak to Professor Oak";
    }

}
