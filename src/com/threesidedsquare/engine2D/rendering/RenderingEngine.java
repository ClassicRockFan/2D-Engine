package com.threesidedsquare.engine2D.rendering;

import com.threesidedsquare.engine2D.object.component.GameObject;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

public class RenderingEngine {

    int numIterations = 0;

    public static void initGL(){
        glMatrixMode(GL_PROJECTION_MATRIX);
        glLoadIdentity();
        glOrtho(0, Window.getWidth(), 0, Window.getHeight(), -1, 1);
        glMatrixMode(GL_MODELVIEW);

        glDisable(GL_DEPTH_TEST);
    }


    public void render(ArrayList<GameObject> objects) {

        glClearColor(0, 0, 0, 1);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        for(GameObject object : objects)
            object.render();

        //Logging.printLog("Rendering: " + numIterations);
        numIterations ++;

        Window.update();
    }
}
