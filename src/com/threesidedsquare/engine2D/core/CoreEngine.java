package com.threesidedsquare.engine2D.core;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.administrative.Time;
import com.threesidedsquare.engine2D.rendering.*;

public class CoreEngine {

    private boolean running;
    private Game game;
    private RenderingEngine renderingEngine;
    private double frameTime;

    public CoreEngine(int width, int height, String title, double frameCap, Game game) {
        Window.createWindow(width, height, title);
        this.running = false;
        this.frameTime = 1 / frameCap;
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
        Logging.printLog("Starting CoreEngine");
        RenderingEngine.initGL();


        this.renderingEngine = new RenderingEngine();
        int frames = 0;
        double frameCounter = 0;

        game.init(this);

        double lastTime = Time.getTime();
        double unprocessedTime = 0;

        while (running) {
            boolean render = false;

            double startTime = Time.getTime();
            double passedTime = startTime - lastTime;
            lastTime = startTime;

            unprocessedTime += passedTime;
            frameCounter += passedTime;

            while (unprocessedTime > frameTime) {
                render = true;

                unprocessedTime -= frameTime;

                if (Window.isCloseRequested()) {
                    stop();
                }

                game.input((float) frameTime);
                game.update((float) frameTime);

                Input.update();

                if (frameCounter >= 1.0) {

                    System.out.println("");
                    Logging.printLog("Running at " + frames + " FPS");
                    System.out.println("Total Time: " + ((1000.0 * frameCounter) / (double) frames) + " ms");
                    System.out.println("");

                    frames = 0;
                    frameCounter = 0;
                }
            }

            if (render) {
                game.render();
                frames++;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
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
