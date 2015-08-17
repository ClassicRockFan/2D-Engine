package com.threesidedsquare.engine2D.rendering.primitive;


import com.threesidedsquare.engine2D.rendering.Texture;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class RectanglePrimitive{

    public static void render(float minX, float minY, float maxX, float maxY, float z) {
        render(minX, minY, maxX, maxY, z, 1, 1, 1);
    }

    public static void render(float minX, float minY, float maxX, float maxY, float z, float r, float g, float b){
        glColor3f(r, g, b);

        glBegin(GL_QUADS);
        {
            glVertex3f(minX, minY, z);
            glVertex3f(minX, maxY, z);
            glVertex3f(maxX, maxY, z);
            glVertex3f(maxX, minY, z);
        }
        glEnd();
    }

    public static void render(float minX, float minY, float maxX, float maxY, float z, Texture texture){
        texture.bind(0);

        glBegin(GL_QUADS);
        {
            glVertex3f(minX, minY, z);
            glTexCoord2f(0, 0);
            glVertex3f(minX, maxY, z);
            glTexCoord2f(0, 1);
            glVertex3f(maxX, maxY, z);
            glTexCoord2f(1, 1);
            glVertex3f(maxX, minY, z);
            glTexCoord2f(1, 0);
        }
        glEnd();
    }

}
