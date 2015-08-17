package com.threesidedsquare.engine2D.rendering.primitive;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class RectanglePrimitive{

    public static void render(float minX, float minY, float maxX, float maxY) {
        render(minX, minY, maxX, maxY, 1, 1, 1);
    }

    public static void render(float minX, float minY, float maxX, float maxY, float r, float g, float b){
        glColor3f(r, g, b);

        glBegin(GL_QUADS);
        {
            glVertex2f(minX, minY);
            glVertex2f(minX, maxY);
            glVertex2f(maxX, maxY);
            glVertex2f(maxX, minY);
        }
        glEnd();
    }

}
