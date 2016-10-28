package modules;

/**
 * Created by Admin on 10/24/2016.
 */
public class Zombie extends GameModuleWithHP{
    public static final int ZOMBIE_WIDTH = 100;
    public static final int ZOMBIE_HEIGHT = 160;
    public boolean isAlive;
    private int HP;

    public Zombie(int x, int y,int hp) {
        super(x,y,ZOMBIE_WIDTH,ZOMBIE_HEIGHT,hp);
    }

}

