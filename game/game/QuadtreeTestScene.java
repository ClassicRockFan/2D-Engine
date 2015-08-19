package game;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.Game;
import com.threesidedsquare.engine2D.core.GameScene;
import com.threesidedsquare.engine2D.core.math.Vector2f;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.object.GameObject;
import com.threesidedsquare.engine2D.object.component.rendering.QuadRender;
import com.threesidedsquare.engine2D.physics.AABB;
import com.threesidedsquare.engine2D.physics.Quadtree;
import com.threesidedsquare.engine2D.rendering.Window;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class QuadtreeTestScene extends GameScene{

    public static final String NAME = "QuadtreeTestScene";

    //private Quadtree tree;
    public QuadtreeTestScene() {
        super(NAME);
      //  this.tree = new Quadtree(new AABB(-1, -1, 1, 1), 0);
    }

    @Override
    public void init(Game game) {
        super.init(game);

        Random r = new Random();
        float RANGE = 50;
        float RANGE2 = (float)(Window.getWidth());

        for(int i = 0; i < 1600; i++) {
            float minX = (r.nextFloat() - 0.5f) * RANGE;
            float minY = (r.nextFloat() - 0.5f) * RANGE;
            float maxX = (r.nextFloat() - 0.5f) * RANGE;
            float maxY = (r.nextFloat() - 0.5f) * RANGE;
//            float minX = -1f;
//            float minY = -1f;
//            float maxX = 1f;
//            float maxY = 1f;
            float red = r.nextFloat();
            float green = r.nextFloat();
            float blue = r.nextFloat();

            GameObject object = new GameObject(new AABB(minX, minY, maxX, maxY)).addComponent(new QuadRender(minX, minY, maxX, maxY, 1, 1, 1));
            //object.getAabb().update(new Vector2f(i, i));
            object.getTransform().setPosition(new Vector3f((r.nextFloat() - 0.5f) * RANGE2, (r.nextFloat() - 0.5f) * RANGE2, 0));
//            object.getTransform().setPosition(new Vector3f(i, i, 0));
            //object.getTransform().setPosition(new Vector3f(0, 0, 0));
            addObject(object);

            //getQuadtree().add(object);
            //Logging.printLog("i = " + i + ": " + tree.add(object));
        }

        Set<GameObject> objects = getQuadtree().queryAll();

        Logging.printLog("num objects in tree = " + objects.size());

//        Iterator it = objects.iterator();
//
//        while (it.hasNext()){
//            tree.remove((GameObject) it.next());
//        }
//
//        Logging.printLog("num objects in tree = " + tree.queryAll().size());

//        game.getEngine().stop();
    }

    @Override
    public void update(float delta) {
        super.update(delta);

//        Iterator it = getQuadtree().queryAll().iterator();
//
//        while (it.hasNext()){
//            GameObject object = (GameObject) it.next();
//            //tree.remove(object);
//            removeObject(object);
//        }

        removeAll();

        init(getGame());
    }
}
