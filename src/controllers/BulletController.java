package controllers;

import modules.GameModule;
import view.GameView;

import java.awt.*;

/**
 * Created by apple on 10/9/16.
 */
public class BulletController extends SingleController implements Contactable {

    public static final int SPEED = 5;

    public BulletController(GameModule gameModule, GameView gameView) {
        super(gameModule, gameView);
        CollisionPool.instance.register(this);
    }

    @Override
    public void run() {
        gameModule.move(-SPEED, 0);
    }

    @Override
    public void onCollide(Contactable contactable) {
        if (contactable instanceof ZombieController) {
            ((ZombieController) contactable).destroy();
            System.out.println("die");
        }
        else if(contactable instanceof YellowZombieController){
            ((YellowZombieController) contactable).getHit(1);
            this.destroy();
        }
    }
}
