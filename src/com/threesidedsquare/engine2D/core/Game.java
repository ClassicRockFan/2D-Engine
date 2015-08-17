package com.threesidedsquare.engine2D.core;

import com.threesidedsquare.engine2D.object.component.GameObject;

import java.util.HashMap;

public abstract class Game {

    private CoreEngine engine;
    private HashMap<String, GameScene> scenes;
    private GameScene activeScene;

    public void init(CoreEngine engine){
        this.engine = engine;
        this.scenes = new HashMap<>();
        this.activeScene = new GameScene("defaultScene");
        activeScene.init(this);
    }

    public void input(float delta){
        activeScene.input(delta);
    }

    public void update(float delta){
        activeScene.update(delta);
    }

    public void render(){
        activeScene.render(engine.getRenderingEngine());
    }

    public CoreEngine getEngine() {
        return engine;
    }

    public HashMap<String, GameScene> getScenes() {
        return scenes;
    }

    public GameScene getActiveScene() {
        return activeScene;
    }

    public void setActiveScene(String sceneName) {
        this.activeScene = scenes.get(sceneName);
    }

    public GameScene addScene(GameScene scene){
        scene.init(this);
        scenes.put(scene.getName(), scene);
        return scene;
    }

    public GameObject addObject(GameObject object){
        activeScene.addObject(object);
        return object;
    }
}
