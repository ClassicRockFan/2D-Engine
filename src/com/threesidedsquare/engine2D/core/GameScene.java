package com.threesidedsquare.engine2D.core;

import com.threesidedsquare.engine2D.object.GameObject;
import com.threesidedsquare.engine2D.physics.AABB;
import com.threesidedsquare.engine2D.physics.Quadtree;
import com.threesidedsquare.engine2D.rendering.RenderingEngine;

import java.util.ArrayList;
import java.util.Iterator;

public class GameScene {

    private ArrayList<GameObject> objects;
    private Game game;

    private Quadtree quadtree;

    private String name;

    public GameScene(String name) {
        this.name = name;
        objects = new ArrayList<>();
        this.quadtree = new Quadtree(new AABB(-1, -1, 1, 1), 0);
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
        quadtree.add(object);
        return object;
    }

    public boolean removeObject(GameObject object){
        objects.remove(object);
        return quadtree.remove(object);
    }

    public void removeAll(){
        Iterator it = getQuadtree().queryAll().iterator();

        while (it.hasNext()){
            removeObject((GameObject) it.next());
        }
    }

    public Quadtree getQuadtree() {
        return quadtree;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }
}
