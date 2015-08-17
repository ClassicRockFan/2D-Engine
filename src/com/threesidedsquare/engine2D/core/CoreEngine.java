package com.threesidedsquare.engine2D.core;

import com.threesidedsquare.engine2D.administrative.Time;

public class CoreEngine {

    private boolean running;
    private Game game;
    private RenderingEngine renderingEngine;


    public CoreEngine(int width, int height, String title, Game game) {
        Window.createWindow(width, height, title);
        this.running = false;
        this.renderingEngine = new RenderingEngine();
        this.game = game;
    }

    public void start(){
        if(running)
            return;

        running = true;
        run();
    }

    public void stop(){
        if(!running)
            return;
        running = false;
    }

    public void run(){
        RenderingEngine.initGL();
        game.init(this);

        while(running){

            if(Window.isCloseRequested())
                stop();

            game.input();
            game.update();

                game.render();
        }

        cleanUp();
    }

    private void cleanUp(){
        Window.cleanUp();
        System.gc();
        System.exit(0);
    }

    public boolean isRunning() {
        return running;
    }

    public Game getGame() {
        return game;
    }

    public RenderingEngine getRenderingEngine() {
        return renderingEngine;
    }
}
