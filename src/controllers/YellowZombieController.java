package controllers;

import modules.GameModule;
import modules.Zombie;
import view.AnimationDrawer;
import view.GameDrawer;

/**
 * Created by Admin on 10/28/2016.
 */
public class YellowZombieController extends SingleController implements Contactable{
    public static final int DEFAULT_LOCATION_RIGHT = GameConfig.instance.getBackgroundWidth() - Zombie.ZOMBIE_WIDTH;
    public static final int DEFAULT_LOCATION_Y = GameConfig.instance.getBackgroundHeight()*2/3;
    public static final int SPEED = 1;

    public YellowZombieController(GameModule gameModule, GameDrawer gameDrawer) {
        super(gameModule, gameDrawer);
        CollisionPool.instance.register(this);
    }

    public static YellowZombieController createZombie(){
        String[] arrName = {"RightWalk (3).png"};
        return new YellowZombieController(
                new Zombie(DEFAULT_LOCATION_RIGHT, DEFAULT_LOCATION_Y,2),
                new AnimationDrawer(arrName)
        );
    }
    public void getHit(int damage){
        ((Zombie)gameModule).decreaseHP(damage);
    }

    @Override
    public void onCollide(Contactable contactable) {
        if (contactable instanceof BulletController) {
            ((BulletController) contactable).destroy();
            System.out.println("die");
        }
    }

    @Override
    public void run() {
        super.run();
        gameModule.move(-SPEED,0);
    }
    //    public YellowZombieController(GameModule gameModule, GameDrawer gameDrawer) {
//        super(gameModule, gameDrawer);
//        CollisionPool.instance.register(this);
//    }
}
