package controllers;

import utils.Utils;
import view.AnimationDrawer;
import view.GameView;

import java.util.Vector;

/**
 * Created by Admin on 10/24/2016.
 */
public class ZombieControllerManager extends ControllerManager{
    ZombieController zombieController;
    YellowZombieController yellowZombieController;
    public static final int DELAY = 150;
    private int count = 150;
    private int countStop = 0;

    public static void create(){

    }

    public ZombieControllerManager(){
        super();
        count ++;
        if (count >= DELAY && countStop < 3){
            count = 0;
            countStop++;
            zombieController = ZombieController.createZombie();
            yellowZombieController = YellowZombieController.createZombie();
            baseControllers.add(zombieController);
            baseControllers.add(yellowZombieController);
        }
//        ZombieController zombieController = ZombieController.createZombie();
        baseControllers.add(zombieController);
    }

//    @Override
//    public void run() {
//        super.run();
//        count ++;
//        if (count >= 150){
//            count = 0;
//            zombieController = ZombieController.createZombie();
//            baseControllers.add(zombieController);
//        }
//    }
}
