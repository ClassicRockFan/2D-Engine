package game;

import com.threesidedsquare.engine2D.core.Game;
import com.threesidedsquare.engine2D.core.GameScene;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.rendering.GameCamera;
import com.threesidedsquare.engine2D.object.GameObject;
import com.threesidedsquare.engine2D.object.component.rendering.RenderBounding;
import com.threesidedsquare.engine2D.physics.AABB;
import com.threesidedsquare.engine2D.rendering.RenderingEngine;
import com.threesidedsquare.engine2D.rendering.Window;

import java.util.Random;

public class AdvancedRenderingTestScene extends GameScene{

    public static final String NAME = "AdvancedRenderingTestScene";

    public AdvancedRenderingTestScene(){
        super(NAME);
    }

    GameCamera camera;

    @Override
    public void init(Game game){
        super.init(game);

        Random r = new Random();
        float RANGE = 75;
        float RANGE2 = (float) (Window.getWidth() * 2);

        for(int i = 0; i < 1000; i++) {
            float minX = (r.nextFloat() - 0.5f) * RANGE;
            float minY = (r.nextFloat() - 0.5f) * RANGE;
            float maxX = (r.nextFloat() - 0.5f) * RANGE;
            float maxY = (r.nextFloat() - 0.5f) * RANGE;
            float red = r.nextFloat();
            float green = r.nextFloat();
            float blue = r.nextFloat();
            float alpha = r.nextFloat();

            GameObject object = new GameObject(new AABB(minX, minY, maxX, maxY)).addComponent(new RenderBounding(red, green, blue));

            object.getTransform().setPosition(new Vector3f((r.nextFloat() - 0.5f) * RANGE2, (r.nextFloat() - 0.5f) * RANGE2, 0));

            addObject(object);
        }

        camera = new GameCamera();
        addObject(camera);
        setCamera(camera);
    }

    @Override
    public void load() {
        super.load();
        //getGame().getEngine().getRenderingEngine().setCamera(camera);
    }

    @Override
    public void render(RenderingEngine engine) {
            super.render(engine);
    }
}
