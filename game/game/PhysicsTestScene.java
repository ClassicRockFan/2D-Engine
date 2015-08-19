package game;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.GameScene;
import com.threesidedsquare.engine2D.core.Input;
import com.threesidedsquare.engine2D.core.math.Vector2f;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.object.GameObject;
import com.threesidedsquare.engine2D.object.component.rendering.QuadRender;
import com.threesidedsquare.engine2D.object.component.rendering.RenderBounding;
import com.threesidedsquare.engine2D.physics.AABB;
import com.threesidedsquare.engine2D.physics.PhysicsComponent;
import com.threesidedsquare.engine2D.rendering.Window;
import org.lwjgl.input.Keyboard;

import java.util.Random;

public class PhysicsTestScene extends GameScene{

    public static final String NAME = "PhysicsTestScene";

    private GameObject object;
    private GameObject object2;

    public PhysicsTestScene() {
        super(NAME);

        Random r = new Random();
        float RANGE = 100;
        float RANGE2 = 500;
        float SPEED = 20;

        for(int i = 0; i < 10; i++) {
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
            float speedX = (r.nextFloat() - 0.5f) * SPEED;
            float speedY = (r.nextFloat() - 0.5f) * SPEED;

            GameObject object = new GameObject(new AABB(minX, minY, maxX, maxY)).addComponent(new RenderBounding(red, green, blue)).addComponent(new PhysicsComponent(new Vector2f(speedX, speedY), new Vector2f(0, 0)));
            //object.getAabb().update(new Vector2f(i, i));
            object.getTransform().setPosition(new Vector3f((r.nextFloat() - 0.5f) * RANGE2, (r.nextFloat() - 0.5f) * RANGE2, 0));
//            object.getTransform().setPosition(new Vector3f(i, i, 0));
            //object.getTransform().setPosition(new Vector3f(0, 0, 0));
            addObject(object);

            //getQuadtree().add(object);
            //Logging.printLog("i = " + i + ": " + tree.add(object));
        }

    }


    @Override
    public void input(float delta) {
        super.input(delta);

        float distance = delta * 5;

        //Logging.printLog("Distance = " + distance);

//        if(Input.getKey(Keyboard.KEY_W)){
//            object.getPhysicsComponent().addVelocity(new Vector2f(0, distance));
//            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
//        }
//        if(Input.getKey(Keyboard.KEY_A)){
//            object.getPhysicsComponent().addVelocity(new Vector2f(-distance, 0));
//            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
//        }
//        if(Input.getKey(Keyboard.KEY_S)){
//            object.getPhysicsComponent().addVelocity(new Vector2f(0, -distance));
//            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
//        }
//        if(Input.getKey(Keyboard.KEY_D)){
//            object.getPhysicsComponent().addVelocity(new Vector2f(distance, 0));
//            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
//        }
//////
//        if(Input.getKey(Keyboard.KEY_UP)){
//            object2.getPhysicsComponent().addVelocity(new Vector2f(0, distance));
//            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
//        }
//        if(Input.getKey(Keyboard.KEY_LEFT)){
//            object2.getPhysicsComponent().addVelocity(new Vector2f(-distance, 0));
//            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
//        }
//        if(Input.getKey(Keyboard.KEY_DOWN)){
//            object2.getPhysicsComponent().addVelocity(new Vector2f(0, -distance));
//            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
//        }
//        if(Input.getKey(Keyboard.KEY_RIGHT)){
//            object2.getPhysicsComponent().addVelocity(new Vector2f(distance, 0));
//            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
//        }

    }
}
