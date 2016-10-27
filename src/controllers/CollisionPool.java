package controllers;

import modules.GameModule;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Nghia on 10/23/2016.
 */
public class CollisionPool implements BaseController {
    private Vector<Contactable> contactableVector;

    private CollisionPool() {
        contactableVector = new Vector<>();
    }


    @Override
    public void run() {
        for(int i = 0; i < contactableVector.size() - 1; i++) {
            for(int j = i + 1; j < contactableVector.size(); j++) {
                Contactable contactablei = contactableVector.get(i);
                Contactable contactablej = contactableVector.get(j);

                GameModule gameModulei = contactablei.getGameModule();
                GameModule gameModulej = contactablej.getGameModule();

                if (gameModulei.checkCollideWith(gameModulej)) {
                    contactablei.onCollide(contactablej);
                    contactablej.onCollide(contactablei);
                }
            }
        }

        Iterator<Contactable> iterator = contactableVector.iterator();
        while(iterator.hasNext()) {
            Contactable baseController = iterator.next();
            if (!baseController.getGameModule().isAlive()) {
                iterator.remove();
            }
        }
    }

    @Override
    public void draw(Graphics graphics) {

    }

    public void register(Contactable contactable) {
        contactableVector.add(contactable);
    }

    public static final CollisionPool instance = new CollisionPool();
}
