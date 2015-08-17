package com.threesidedsquare.engine2D.object;

import com.threesidedsquare.engine2D.core.Transform;
import com.threesidedsquare.engine2D.core.math.Vector2f;
import com.threesidedsquare.engine2D.object.component.GameComponent;
import com.threesidedsquare.engine2D.physics.AABB;
import com.threesidedsquare.engine2D.physics.PhysicsComponent;

import java.util.ArrayList;

public class GameObject {

    private static int counter = 0;

    private int id;
    private Transform transform;
    private ArrayList<GameComponent> components;
    private AABB aabb;
    private PhysicsComponent component;

    public GameObject() {
        this(new AABB(new Vector2f(-1, -1), new Vector2f(1, 1)));
    }

    public GameObject(AABB aabb) {
        this.id = counter;
        this.components = new ArrayList<>();
        this.transform = new Transform();
        this.aabb = aabb;
        this.component = null;

        counter++;
    }

    public void input(float delta){
        for(GameComponent component: components)
            component.input(delta);
    }

    public void update(float delta){
        for(GameComponent component: components)
            component.update(delta);

        aabb.update(getTransform().getPosition().XY());
    }

    public void render(){
        for(GameComponent component: components)
            component.render();
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

    @Override
    public String toString() {
        return "GameObject_" + id;
    }
}
