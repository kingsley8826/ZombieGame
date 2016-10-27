package controllers;

import utils.Utils;
import view.AnimationDrawer;
import view.GameView;

import java.util.Vector;

/**
 * Created by Admin on 10/24/2016.
 */
public class ZombieControllerManager extends ControllerManager{
//    ZombieController zombieController;
    public static final int DELAY = 150;
    private int count = 150;


    public ZombieControllerManager(){
        super();
        ZombieController zombieController = ZombieController.createZombie();
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
