import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import controllers.ControllerManager;
import controllers.GameConfig;
import controllers.PlayerController;
import controllers.ZombieControllerManager;
import modules.Player;
import utils.*;
import view.AnimationDrawer;
import view.GameView;


/**
 * Created by Nghia on 10/23/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image backgroundImage;
    Image backBufferImage;
    PlayerController playerController;
    ZombieControllerManager zombieControllerManager;
    ControllerManager controllerManager;

    public static int dx;
    public static int dy;

    public GameWindow()  {
        controllerManager = new ControllerManager();
        int backgroundWith = GameConfig.instance.getBackgroundWidth();
        int backgroundHeight = GameConfig.instance.getBackgroundHeight();
        backgroundImage = Utils.loadImageFromResources("background.png");
        backBufferImage = new BufferedImage(backgroundWith,backgroundHeight,BufferedImage.TYPE_INT_ARGB);

        playerController = new PlayerController(
                                new AnimationDrawer("gamePlayer_left_", 1, 0)
                                );
        zombieControllerManager = new ZombieControllerManager();

        controllerManager.add(playerController);
        controllerManager.add(zombieControllerManager);


        this.setVisible(true);
        this.setSize(GameConfig.instance.getBackgroundWidth(),
                        GameConfig.instance.getBackgroundHeight());
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                playerController.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                playerController.keyReleased(e);
            }
        });
    }
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        System.out.println("loaded");

    }

    public void update(Graphics graphics){
        Graphics backbufferedGraphics = backBufferImage.getGraphics();
        backbufferedGraphics.drawImage(backgroundImage,0,0,
                                        GameConfig.instance.getBackgroundWidth(),
                                        GameConfig.instance.getBackgroundHeight(),
                                        null);

        backbufferedGraphics.drawImage(backgroundImage, -dx, 0,
                                    GameConfig.instance.getBackgroundWidth(),
                                    GameConfig.instance.getBackgroundHeight(),
                                    null);

        controllerManager.draw(backbufferedGraphics);



        graphics.drawImage(backBufferImage,
                        0,0,
                        GameConfig.instance.getBackgroundWidth(),
                        GameConfig.instance.getBackgroundHeight(),
                        null);

    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(GameConfig.instance.getThreadDelayInMiliseconds());
                controllerManager.run();
                if (playerController.getGameModule().getX() > GameConfig.instance.getBackgroundWidth()/2) {
                    GameWindow.dx = playerController.getGameModule().getX() - GameConfig.instance.getBackgroundWidth()/2;
                }
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
