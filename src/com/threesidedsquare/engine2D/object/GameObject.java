package com.threesidedsquare.engine2D.object;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.GameScene;
import com.threesidedsquare.engine2D.core.Transform;
import com.threesidedsquare.engine2D.core.math.Vector2f;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.object.component.GameComponent;
import com.threesidedsquare.engine2D.physics.AABB;
import com.threesidedsquare.engine2D.physics.PhysicsComponent;

import java.util.ArrayList;

public class GameObject implements Comparable<GameObject>{

    private static int counter = 0;

    private int id;
    private Transform transform;
    private ArrayList<GameComponent> components;
    private AABB aabb;
    private PhysicsComponent component;
    private GameScene scene;

    private Vector3f oldPos;


    public GameObject() {
        this(new AABB(new Vector2f(-1, -1), new Vector2f(1, 1)));
    }

    public GameObject(AABB aabb) {
        this.id = counter;
        this.components = new ArrayList<>();
        this.transform = new Transform(this);
        this.aabb = aabb;
        this.component = null;
        this.oldPos = transform.getPosition();
        counter++;
    }

    public void input(float delta){
        oldPos = transform.getPosition();
        for(GameComponent component: components)
            component.input(delta);
    }

    public void update(float delta){
        for(GameComponent component: components)
            component.update(delta);

        Vector3f curentPos = transform.getPosition();
        float x = (oldPos.getX() - curentPos.getX());
        float y = (curentPos.getY() - oldPos.getY());

//        Logging.printLog("CurrentPos - " + curentPos);
//        Logging.printLog("OldPos - " + oldPos);

//        if(x > 0 || y > 0){
        removeAndUpdate();
//        }
    }

    public void render(){
        for(GameComponent component: components)
            component.render();
    }

    public void removeAndUpdate(){
        scene.removeObject(this);
        updateAABB();
        scene.addObject(this);
    }

    public void updateAABB(){
        aabb.update(getTransform().getPosition().XY());
    }

    public GameObject addComponent(GameComponent component){
        components.add(component);
        component.setParent(this);
        return this;
    }

    public Transform getTransform() {
        return transform;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public ArrayList<GameComponent> getComponents() {
        return components;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public AABB getAabb() {
        return aabb;
    }

    public void setAabb(AABB aabb) {
        this.aabb = aabb;
    }

    public PhysicsComponent getPhysicsComponent() {
        return component;
    }

    public void setPhysicsComponent(PhysicsComponent component) {
        this.component = component;
    }

    public GameScene getScene() {
        return scene;
    }

    public void setScene(GameScene scene) {
        this.scene = scene;
    }

    @Override
    public String toString() {
        return "GameObject_" + id;
    }

    @Override
    public int compareTo(GameObject r) {

        final int BEFORE = -1;
        final int AFTER = 1;
        final int EQUAL = 0;
        if(this == r) {
            return EQUAL;
        }
        if(getTransform().getPosition().getZ() < r.getTransform().getPosition().getZ()) {
            return AFTER;
        }
        return BEFORE;
    }
}
