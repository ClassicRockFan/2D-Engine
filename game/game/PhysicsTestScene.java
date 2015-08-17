package game;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.GameScene;
import com.threesidedsquare.engine2D.core.Input;
import com.threesidedsquare.engine2D.core.math.Vector2f;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.object.GameObject;
import com.threesidedsquare.engine2D.object.component.rendering.QuadRender;
import com.threesidedsquare.engine2D.physics.AABB;
import com.threesidedsquare.engine2D.physics.PhysicsComponent;
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
        float RANGE2 = 100;
        float SPEED = 2;


        //for(int i = 0; i < 2; i++) {
//            float minX = r.nextFloat() * RANGE;
//            float minY = r.nextFloat() * RANGE;
//            float maxX = r.nextFloat() * RANGE;
//            float maxY = r.nextFloat() * RANGE;
            float red = r.nextFloat();
            float green = r.nextFloat();
            float blue = r.nextFloat();

            object = new GameObject().addComponent(new QuadRender(-100, -100, 100, 100, red, green, blue));
            object.setAabb(new AABB(-100, -100, 100, 100));
            //if(i == 0) {
                object.getTransform().setPosition(new Vector3f(-10, -10, 0));
                object.addComponent(new PhysicsComponent(new Vector2f(SPEED, SPEED), new Vector2f(0, 0)));
            //}else{

        object2 = new GameObject().addComponent(new QuadRender(-100, -100, 100, 100, red, green, blue));
        object2.setAabb(new AABB(-100, -100, 100, 100));
        object2.getTransform().setPosition(new Vector3f(300, 300, 0));
        object2.addComponent(new PhysicsComponent(new Vector2f(-SPEED, -SPEED), new Vector2f(0, 0)));
            //}
            addObject(object);
        addObject(object2);

    }

    @Override
    public void input(float delta) {
        super.input(delta);

        float distance = delta * 5;

        //Logging.printLog("Distance = " + distance);

        if(Input.getKey(Keyboard.KEY_W)){
            object.getPhysicsComponent().addVelocity(new Vector2f(0, distance));
            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
        }
        if(Input.getKey(Keyboard.KEY_A)){
            object.getPhysicsComponent().addVelocity(new Vector2f(-distance, 0));
            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
        }
        if(Input.getKey(Keyboard.KEY_S)){
            object.getPhysicsComponent().addVelocity(new Vector2f(0, -distance));
            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
        }
        if(Input.getKey(Keyboard.KEY_D)){
            object.getPhysicsComponent().addVelocity(new Vector2f(distance, 0));
            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
        }
////
        if(Input.getKey(Keyboard.KEY_UP)){
            object2.getPhysicsComponent().addVelocity(new Vector2f(0, distance));
            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
        }
        if(Input.getKey(Keyboard.KEY_LEFT)){
            object2.getPhysicsComponent().addVelocity(new Vector2f(-distance, 0));
            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
        }
        if(Input.getKey(Keyboard.KEY_DOWN)){
            object2.getPhysicsComponent().addVelocity(new Vector2f(0, -distance));
            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
        }
        if(Input.getKey(Keyboard.KEY_RIGHT)){
            object2.getPhysicsComponent().addVelocity(new Vector2f(distance, 0));
            //Logging.printLog("New Pos = " + object.getTransform().getPosition().toString());
        }

    }
}
