package view;

import modules.GameModule;

import java.awt.*;

/**
 * Created by Nghia on 10/23/2016.
 */
public class GameView extends GameDrawer {
    Image image;

    public GameView(Image image) {
        this.image = image;
    }

    @Override
    public void drawImage(Graphics g, GameModule gameModule) {
        g.drawImage(
                image,
                gameModule.getX(),
                gameModule.getY(),
                gameModule.getWidth(),
                gameModule.getHeight(),
                null);
    }
}
