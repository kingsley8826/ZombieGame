package modules;

/**
 * Created by Nghia on 10/23/2016.
 */
public class Player extends GameModuleWithHP {
    public static final int WIDTH = 135;
    public static final int HEIGHT = 148;
    public static final int DEFAULT_HP = 3;


    public Player(int x, int y) {
        super(x, y, WIDTH, HEIGHT,DEFAULT_HP);
    }

}
