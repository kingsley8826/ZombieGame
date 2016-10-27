package controllers;

import modules.GameModule;
import view.GameDrawer;
import view.GameView;

import java.awt.*;

/**
 * Created by Nghia on 10/23/2016.
 */
public class SingleController implements BaseController {
    GameModule gameModule;
    GameDrawer gameDrawer;

    public SingleController(GameModule gameModule, GameDrawer gameDrawer) {
        this.gameModule = gameModule;
        this.gameDrawer = gameDrawer;
    }

    public GameModule getGameModule() {
        return gameModule;
    }

    public void run() {
        if (GameConfig.instance.xOutsideScreen(gameModule)) {
            gameModule.setAlive(false);
        }
    }

    public void destroy() {
        gameModule.setAlive(false);
    }

    public void draw(Graphics graphics){
        gameDrawer.drawImage(graphics, gameModule);
    }


}
