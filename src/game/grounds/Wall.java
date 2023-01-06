package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.tools.Status;

public class Wall extends Ground {

	public Wall() {
		super('#');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

	@Override
	public void addCapability(Enum<?> capability) {
		super.addCapability(capability);
		addCapability(Status.NONCONVERTIBLE);

	}
}
