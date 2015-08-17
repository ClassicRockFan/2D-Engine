package com.threesidedsquare.engine2D.core;

import com.threesidedsquare.engine2D.object.GameObject;
import com.threesidedsquare.engine2D.rendering.RenderingEngine;

import java.util.ArrayList;

public class GameScene {

    private ArrayList<GameObject> objects;
    private Game game;

    private String name;

    public GameScene(String name) {
        this.name = name;
        objects = new ArrayList<>();
    }

    public void init(Game game){
        this.game = game;
    }

    public void input(float delta){
        for(GameObject object : objects)
            object.input(delta);
    }

    public void update(float delta){
        for(GameObject object : objects)
            object.update(delta);
    }

    public void render(RenderingEngine engine){
        engine.render(getObjects());
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    public GameObject addObject(GameObject object){
        objects.add(object);
        return object;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }
}
