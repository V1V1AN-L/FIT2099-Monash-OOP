package game.items.ball;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.action.*;
import game.affection.AffectionManager;
import game.pokemon.PokemonBase;
import game.tools.Status;

/**
 * Candy can be used to be traded as exchange value
 * Created by: Zecan (Vivian) Liu
 *
 * @author zliu0207
 * Modified by: Jordan Nathanael
 */
public abstract class GeneralBall extends Item {
    /**
     * Pokemon that is inside the GenerallBall
     */
    protected PokemonBase storedPokemon;

    /**
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public GeneralBall(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        clearActions();

        if (storedPokemon != null){
            addAction(new SummonAction(this));
        }

        // CatchAction will only appear after the actor does an action in the first turn
        // means that when we run the game and there is a pokemon near the Player, catchAction won't appear only for the first turn
        // It happens because of the limitation of the game engine. especially the tick() method.
        // Specifically, tick() for Item is done after the processActorTurn.
        for (Exit exit : currentLocation.getExits()){
            Location targetLoc = exit.getDestination();
            if (targetLoc.containsAnActor()){
                Actor targetActor = targetLoc.getActor();
                if (targetActor.hasCapability(Status.CATCHABLE)){
                    addAction(new CatchAction(targetActor, exit.getName(), this));
                }
            }
        }

        super.tick(currentLocation, actor);
    }

    /**
     * Get the pokemon that is inside the ball
     *
     * @return the pokemon inside the ball
     */
    public PokemonBase getStoredPokemon() {
        return storedPokemon;
    }

    /**
     * Check the pokemon that want to be captured whether it fulfills the req of affection point or not
     * This class will be overridden by the concrete class to check it based on the AffectionLevelPoint
     *
     * @see game.affection.AffectionLevelPoint
     *
     * @param storedPokemon actor that is registered into this ball
     * @param affectionPoint the affection point of the pokemon
     * @return true if actor that want to be captured is a pokemon
     * @throws Exception "Can't captured any actor other than pokemon"
     */
    public boolean checkAffectionPointReq(Actor storedPokemon, int affectionPoint) throws Exception{
        PokemonBase pokemon = AffectionManager.getInstance().findPokemon(storedPokemon);
        if (pokemon == null) {
            throw new Exception("Can't captured any other than Pokemon");
        }
        return true;
    }

    /**
     * Set the stored pokemon into the generalball
     *
     * @param storedPokemon the pokemon that want to be stored inside the generalball
     */
    public void setStoredPokemon(Actor storedPokemon){
        PokemonBase pokemon = AffectionManager.getInstance().findPokemon(storedPokemon);
        this.storedPokemon = pokemon;

        // Once the ball is filled with pokemon
        // there is no option to drop the pokeball
        this.togglePortability();
    }

    /**
     * It is used when summonAction is done.
     * Clear the pokemon that is stored before, so this generalball can be used to contains another pokemon with another catchAction
     */
    public void setStoredPokemonNull(){
        this.storedPokemon = null;

        // Once the ball is empty after summon,
        // the ball can is portable again
        this.togglePortability();
    }
}
