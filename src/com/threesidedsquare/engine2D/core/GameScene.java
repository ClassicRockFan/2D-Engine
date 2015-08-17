package com.threesidedsquare.engine2D.core;

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

    public void input(){
        for(GameObject object : objects)
            object.input();
    }

    public void update(){
        for(GameObject object : objects)
            object.update();
    }

    public void render(){
        game.getEngine().getRenderingEngine().render(getObjects());
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
