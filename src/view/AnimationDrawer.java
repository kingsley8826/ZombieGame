package view;

import controllers.GameConfig;
import modules.GameModule;
import utils.Utils;

import java.awt.*;
import java.util.Vector;

/**
 * Created by User on 10/27/2016.
 */
public class AnimationDrawer extends GameDrawer {
    private Vector<Image> imageVector;
    private int index = 0;
    private int count = 0;
    private int repeatCount = 0;

    public int getRepeatCount() {
        return repeatCount;
    }

    public AnimationDrawer(String[] arrName){
        imageVector = new Vector<>();
        for (String name : arrName){
            Image image = Utils.loadImageFromResources(name);
            imageVector.add(image);
        }
    }

    public AnimationDrawer(String imagePath, int numberFrame, int num){
        imageVector = new Vector<>();

        for (int i = 1; i <= numberFrame; i++){
            Image image = Utils.loadImageFromResources(imagePath + (i+num) +".png");
            imageVector.add(image);
        }
    }

    public AnimationDrawer(Vector<Image> imageVector){
        this.imageVector = imageVector;
    }

    @Override
    public void drawImage(Graphics g, GameModule gameModule) {
        Image image = imageVector.get(index);
        g.drawImage(image,
                gameModule.getX(),
                gameModule.getY(),
                gameModule.getWidth(),
                gameModule.getHeight(),
                null);
        count++;
        if(GameConfig.instance.getMiliseconds(count) > 250) {
            count = 0;
            index++;
            if (index >= imageVector.size()) {
                repeatCount++;
                index = 0;
            }
        }
    }
}
