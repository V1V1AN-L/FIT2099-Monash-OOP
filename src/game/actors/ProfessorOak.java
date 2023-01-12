package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.*;
/**
 *  ProfessorOak , singleton class that interacts with the Player and is part of the EndGameAction
 * Created by: Aashlesha Gaur
 * @author Aashlesha Gaur
 */

public class ProfessorOak extends Actor {


    private static final char DEFAULT_DISPLAY_CHAR = '$';
    private static final String DEFAULT_NAME = "Professor Oak";

    private static ProfessorOak professorOak;

    private ProfessorOak() {
        super(DEFAULT_NAME,DEFAULT_DISPLAY_CHAR, 0);
    }
//Singleton
    public static ProfessorOak getInstance(){
        if(professorOak == null){
            professorOak = new ProfessorOak();
        }
        return professorOak;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList result = super.allowableActions(otherActor,direction,map);
        result.add(new EndGameAction());
        return result;
    }
}
