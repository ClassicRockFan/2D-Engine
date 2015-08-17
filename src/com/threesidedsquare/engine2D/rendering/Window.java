package com.threesidedsquare.engine2D.rendering;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {

    public static void createWindow(int width, int height, String title){
        Display.setTitle(title);

        try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    public static void update(){
        Display.update();
        //Display.sync(60);
    }

    public static boolean isCloseRequested(){
        return Display.isCloseRequested();
    }

    public static void cleanUp(){
        Display.destroy();
    }

    public static double getWidth(){
        return Display.getWidth();
    }

    public static double getHeight(){
        return Display.getHeight();
    }

}
