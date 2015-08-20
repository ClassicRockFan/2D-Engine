package com.threesidedsquare.engine2D.rendering.primitive;


import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.rendering.Texture;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class RectanglePrimitive{

    public static final float NO_ALPHA = -1;

    public static void render(float minX, float minY, float maxX, float maxY, float z) {
        render(minX, minY, maxX, maxY, z, 1, 1, 1);
    }

    public static void render(float minX, float minY, float maxX, float maxY, float z, float r, float g, float b){
        render(minX, minY, maxX, maxY, z, r, g, b, NO_ALPHA);
    }

    public static void render(float minX, float minY, float maxX, float maxY, float z, float r, float g, float b, float a){
        if(a == NO_ALPHA)
            glDisable(GL_BLEND);
        glColor4f(r, g, b, a);

        glBegin(GL_QUADS);
        {
            glVertex3f(minX, minY, z);
            glVertex3f(minX, maxY, z);
            glVertex3f(maxX, maxY, z);
            glVertex3f(maxX, minY, z);
        }
        glEnd();

        if(a == NO_ALPHA)
            glEnable(GL_BLEND);

        glColor3f(1, 1, 1);

    }

    public static void render(float minX, float minY, float maxX, float maxY, float z, Texture texture){
        render(minX, minY, maxX, maxY, z, 0, 0, 1, 1, texture);
    }

    public static void render(float minX, float minY, float maxX, float maxY, float z, Texture texture, Vector3f shading){
        render(minX, minY, maxX, maxY, z, 0, 0, 1, 1, texture, shading);
    }

    public static void render(float minX, float minY, float maxX, float maxY, float z, float uvMinX, float uvMinY, float uvMaxX, float uvMaxY, Texture texture){
        render(minX, minY, maxX, maxY, z, uvMinX, uvMinY, uvMaxX, uvMaxY, texture, new Vector3f(1, 1, 1));
    }

    public static void render(float minX, float minY, float maxX, float maxY, float z, float uvMinX, float uvMinY, float uvMaxX, float uvMaxY, Texture texture, Vector3f shading){
        texture.bind(0);
//        Logging.printLog("Id of the active texture - " + texture.getId());
        glColor3f(shading.getX(), shading.getY(), shading.getZ());
        glBegin(GL_QUADS);
        {
            glTexCoord2f(uvMinX, uvMinY);
            glVertex3f(minX, minY, z);
            glTexCoord2f(uvMinX, uvMaxY);
            glVertex3f(minX, maxY, z);
            glTexCoord2f(uvMaxX, uvMaxY);
            glVertex3f(maxX, maxY, z);
            glTexCoord2f(uvMaxX, uvMinY);
            glVertex3f(maxX, minY, z);

        }
        glEnd();
    }

}
