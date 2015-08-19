package com.threesidedsquare.engine2D.core;

import com.threesidedsquare.engine2D.object.GameCamera;
import com.threesidedsquare.engine2D.object.GameObject;
import com.threesidedsquare.engine2D.physics.AABB;
import com.threesidedsquare.engine2D.physics.Quadtree;
import com.threesidedsquare.engine2D.rendering.RenderingEngine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class GameScene {

    private ArrayList<GameObject> objects;
    private Game game;

    private Quadtree quadtree;

    private String name;
    private GameCamera camera;

    public GameScene(String name) {
        this.name = name;
        objects = new ArrayList<>();
        this.quadtree = new Quadtree(new AABB(-1, -1, 1, 1), 0);
        this.camera = new GameCamera();
    }

    public void init(Game game){
        this.game = game;
    }

    public void input(float delta){
        for(GameObject object : objects)
            object.input(delta);
    }

    public void load(){
        getGame().getEngine().getRenderingEngine().setCamera(camera);
    }

    public void update(float delta){
        Iterator it = quadtree.queryAll().iterator();

        while(it.hasNext()){
            GameObject object = (GameObject) it.next();

            object.update(delta);
        }
    }

    public void render(RenderingEngine engine){
        Set<GameObject> objects = quadtree.queryRange(engine.getCamera().getFrustum());

        ArrayList<GameObject> drawList = new ArrayList<>();

        Iterator it = objects.iterator();

        while (it.hasNext()){
            drawList.add((GameObject)it.next());
        }

        engine.render(drawList);
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    public GameObject addObject(GameObject object){
        objects.add(object);
        quadtree.add(object);
        object.setScene(this);
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

    public GameCamera getCamera() {
        return camera;
    }

    public void setCamera(GameCamera camera) {
        this.camera = camera;
    }
}
