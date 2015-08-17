package com.threesidedsquare.engine2D.rendering;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.Util;
import javafx.scene.control.TextArea;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL30.*;

public class Texture {

    private int id;
    private String path;
    private int width;
    private int height;

    public Texture(String path){
        this(path, GL_LINEAR);
    }

    public Texture(String path, int filter) {
        this.path = path;
        loadTexture("./res/textures/" + path, filter);
    }

    private void loadTexture(String path, int filter) {
        Logging.printLog("Loading texture at path - " + path);
        try {
            BufferedImage image = ImageIO.read(new File(path));
            width = image.getWidth();
            height = image.getHeight();

            int[] pixels = image.getRGB(0, 0, width, height, null, 0, width);

            ByteBuffer buffer = Util.createByteBuffer(height * width * 4);
            boolean hasAlpha = image.getColorModel().hasAlpha();

            for (int y = 0; y < height; y++){
                for(int x = 0; x < width; x++){
                    int pixel = pixels[y * width + x];

                    buffer.put((byte) ((pixel >> 16) & 0xFF));
                    buffer.put((byte) ((pixel >> 8) & 0xFF));
                    buffer.put((byte) ((pixel) & 0xFF));

                    if(hasAlpha)
                        buffer.put((byte) ((pixel >> 24) & 0xFF));
                    else
                        buffer.put((byte) (0xFF));
                }
            }

            buffer.flip();

            this.id = glGenTextures();
            glBindTexture(GL_TEXTURE_2D, id);

            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, filter);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, filter);

            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
        } catch (IOException e) {
            e.printStackTrace();
            Logging.printLog("Problem loading textures - path = " + path);
        }
    }

    public void bind(int samplerSlot) {
//        assert (samplerSlot >= 0 && samplerSlot <= 31);
//        glActiveTexture(GL_TEXTURE0 + samplerSlot);
        glBindTexture(GL_TEXTURE_2D, id);
    }



    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
