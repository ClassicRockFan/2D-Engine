package game;

import com.threesidedsquare.engine2D.core.CoreEngine;
import com.threesidedsquare.engine2D.administrative.ConsoleWindow;
import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.Game;
import com.threesidedsquare.engine2D.core.GameObject;
import com.threesidedsquare.engine2D.core.math.Vector3f;

import java.util.Random;

public class Main extends Game{

    public static void main(String[] args){
        System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/lib/natives-win");
        Logging.printLog("Successfully Linked Natives");

        ConsoleWindow.getInstance().setVisible(true);
        CoreEngine engine = new CoreEngine(800, 600, "2D Game Engine", new Main());
        engine.start();
    }

    @Override
    public void init(CoreEngine engine) {
        super.init(engine);

        Random r = new Random();
        float RANGE = 30;
        float RANGE2 = 800;

        for(int i = 0; i < 10000; i++) {
            float minX = r.nextFloat() * RANGE;
            float minY = r.nextFloat() * RANGE;
            float maxX = r.nextFloat() * RANGE;
            float maxY = r.nextFloat() * RANGE;
            float red = r.nextFloat();
            float green = r.nextFloat();
            float blue = r.nextFloat();

            GameObject object = new GameObject().addComponent(new QuadRender(minX, minY, maxX, maxY, red, green, blue));

            object.getTransform().setPosition(new Vector3f(r.nextFloat() * RANGE2, r.nextFloat() * RANGE2, r.nextFloat() * RANGE2));

            addObject(object);
        }
    }

    @Override
    public void input() {
        super.input();
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render() {
        super.render();
    }
}
