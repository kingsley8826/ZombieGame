package controllers;

import modules.GameModule;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Nghia on 10/23/2016.
 */
public class ControllerManager implements BaseController{
    protected Vector<BaseController> baseControllers;

    public ControllerManager() {
        this.baseControllers = new Vector<>();
    }

    public void add(BaseController baseController) {
        this.baseControllers.add(baseController);
    }

    @Override
    public void run() {
        synchronized (baseControllers) {
            Iterator<BaseController> iterator = baseControllers.iterator();
            while (iterator.hasNext()) {
                BaseController baseController = iterator.next();
                if (baseController instanceof SingleController) {
                    GameModule gameModule =
                            ((SingleController) baseController).getGameModule();
                    if (!gameModule.isAlive()) {
                        iterator.remove();
                    } else {
                        baseController.run();
                    }
                } else {
                    baseController.run(); // Manager
                }
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        for(BaseController baseController : baseControllers) {
            baseController.draw(g);
        }
    }
}

