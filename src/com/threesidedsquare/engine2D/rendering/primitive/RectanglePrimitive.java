package com.threesidedsquare.engine2D.rendering.primitive;


import com.threesidedsquare.engine2D.rendering.Texture;

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

    public static void render(float minX, float minY, float maxX, float maxY, Texture texture){
        texture.bind(0);

        glBegin(GL_QUADS);
        {
            glVertex2f(minX, minY);
            glTexCoord2f(0, 0);
            glVertex2f(minX, maxY);
            glTexCoord2f(0, 1);
            glVertex2f(maxX, maxY);
            glTexCoord2f(1, 1);
            glVertex2f(maxX, minY);
            glTexCoord2f(1, 0);
        }
        glEnd();
    }

}
