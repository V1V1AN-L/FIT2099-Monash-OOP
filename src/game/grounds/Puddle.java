package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;

import java.util.Random;

public class Puddle extends ConvertibleGrounds{
    /**
     * Constructor.
     *
     */
    public Puddle() {
        super('~', Element.WATER);
    }

    @Override
    public void dayEffect() {
        int randomNum = new Random().nextInt(9);
        if (randomNum == 0) {
            destroyGround();
        }
    }

    @Override
    public void nightEffect() {
        int randomNum = new Random().nextInt(9);
        if(randomNum == 0){
            Puddle puddle = new Puddle();
            expandGround(puddle);
        }
    }
}
