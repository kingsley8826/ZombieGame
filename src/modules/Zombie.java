package modules;

/**
 * Created by Admin on 10/24/2016.
 */
public class Zombie extends GameModule{
    public static final int ZOMBIE_WIDTH = 40;
    public static final int ZOMBIE_HEIGHT = 60;
    public boolean isAlive;

    public Zombie(int x, int y) {
        super(x,y,ZOMBIE_WIDTH,ZOMBIE_HEIGHT);
    }

}

