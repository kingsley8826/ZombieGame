package modules;

import java.awt.*;

/**
 * Created by Nghia on 10/23/2016.
 */
public class GameModule {
    private int x;
    private int y;
    final int width;
    final int height;
    protected boolean isAlive;

    public GameModule(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        isAlive = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void move(double dx, double dy){
        x+=dx;
        y+=dy;
    }

    private Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public boolean checkCollideWith(GameModule gameModule) {
        Rectangle rect1 = this.getRect();
        Rectangle rect2 = gameModule.getRect();
        return rect1.intersects(rect2);
    }
}
