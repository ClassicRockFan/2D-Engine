package com.threesidedsquare.engine2D.core;

import java.util.AbstractCollection;
import java.util.ArrayList;

public class GameObject {

    private static int counter = 0;

    private int id;
    private Transform transform;
    private ArrayList<GameComponent> components;

    public GameObject() {
        this.id = counter;
        this.components = new ArrayList<>();
        this.transform = new Transform();

        counter++;
    }

    public void input(){
        for(GameComponent component: components)
            component.input();
    }

    public void update(){
        for(GameComponent component: components)
            component.update();
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
}
