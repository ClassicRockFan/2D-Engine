package com.threesidedsquare.engine2D.rendering;



import com.threesidedsquare.engine2D.core.math.Vector2f;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextureSheet {

    private String path;
    private float widthImage;
    private float heightImage;
    private float widthSprite;
    private float heightSprite;
    private int gridWidth;
    private int numX;
    private int numY;
    private float scale;


    public TextureSheet(String path, int numX, int numY, int gridWidth, float scale) {
        this.path = path;
        this.gridWidth = gridWidth;
        this.numX = numX;
        this.numY = numY;
        this.scale = scale;
        try {
            BufferedImage image = ImageIO.read(new File("./res/textures/" + path));

            this.widthImage = (float)image.getWidth();
            this.heightImage = (float)image.getHeight();

            this.widthSprite = widthImage/(float)(numX);
            this.heightSprite = heightImage/(float)(numY);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public float[] generateTexCoords(int gridX, int gridY, boolean gridBottom, boolean gridTop, boolean gridLeft, boolean gridRight){

        int offsetTop = 0;
        int offsetBottom = 0;
        int offsetLeft = 0;
        int offsetRight = 0;

        if(gridBottom)
            offsetBottom = 1;
        if(gridTop)
            offsetTop = 1;
        if(gridLeft)
            offsetLeft = 1;
        if(gridRight)
            offsetRight = 1;

        float texMinX = (widthSprite * gridX + offsetLeft)/widthImage;
        float texMaxX = texMinX + ((widthSprite - 2*offsetRight)/widthImage);
        float texMinY = (heightSprite * gridY + offsetBottom)/heightImage;
        float texMaxY = texMinY + ((heightSprite - 2*offsetTop )/heightImage);

        float[] result = new float[]{
                texMinX,
                texMinY,
                texMaxX,
                texMaxY
        };


        return result;
    }

    public String getPath() {
        return path;
    }

    public float getWidthImage() {
        return widthImage;
    }

    public float getHeightImage() {
        return heightImage;
    }

    public float getWidthSprite() {
        return widthSprite;
    }

    public float getHeightSprite() {
        return heightSprite;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public int getNumX() {
        return numX;
    }

    public int getNumY() {
        return numY;
    }

    public float getScale() {
        return scale;
    }
}
