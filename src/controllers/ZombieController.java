package controllers;

import modules.GameModule;
import modules.Zombie;
import view.AnimationDrawer;
import view.GameDrawer;
import view.GameView;

import java.awt.*;

/**
 * Created by Admin on 10/24/2016.
 */
public class ZombieController extends SingleController implements Contactable{
    public static final int DEFAULT_LOCATION_X = 0;
    public static final int DEFAULT_LOCATION_Y = GameConfig.instance.getBackgroundHeight()*2/3;

    private int dx;
    private int dy;
    public static final int SPEED = 1;

    public ZombieController(GameModule gameModule, GameDrawer gameDrawer) {
        super(gameModule, gameDrawer);
        CollisionPool.instance.register(this);
    }

    public int getX(){
        return gameModule.getX();
    }
    public int getY(){
        return gameModule.getY();
    }

    public static ZombieController createZombie(){
        return new ZombieController(
                new Zombie(DEFAULT_LOCATION_X, DEFAULT_LOCATION_Y),
                new AnimationDrawer("zombie_female/Walk_", 10, 0)
        );
    }

//    @Override
//    public void destroy() {
//        super.destroy();
//    }

    @Override
    public void run() {
//        super.run();
        gameModule.move(SPEED,0);
    }

    @Override
    public void onCollide(Contactable contactable) {
        if (contactable instanceof BulletController) {
            ((BulletController) contactable).destroy();
            System.out.println("die");
        }
    }
}
