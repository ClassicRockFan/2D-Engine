package game;

import com.threesidedsquare.engine2D.core.CoreEngine;
import com.threesidedsquare.engine2D.core.Game;
import com.threesidedsquare.engine2D.core.GameScene;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.object.component.GameObject;
import com.threesidedsquare.engine2D.object.component.rendering.QuadRender;

import java.util.Random;

public class RenderTestScene extends GameScene{

    public static final String NAME = "RenderTest";

    public RenderTestScene() {
        super(NAME);
    }

    @Override
    public void init(Game game) {
        super.init(game);

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
}
