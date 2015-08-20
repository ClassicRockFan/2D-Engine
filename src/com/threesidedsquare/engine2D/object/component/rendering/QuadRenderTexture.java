package com.threesidedsquare.engine2D.object.component.rendering;

import com.threesidedsquare.engine2D.core.math.Vector2f;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.object.component.GameComponent;
import com.threesidedsquare.engine2D.rendering.Texture;
import com.threesidedsquare.engine2D.rendering.primitive.RectanglePrimitive;

public class QuadRenderTexture extends GameComponent{

    private float minX;
    private float miny;
    private float maxX;
    private float maxY;

    private float uvMinX;
    private float uvMinY;
    private float uvMaxX;
    private float uvMaxY;

    private Texture texture;

    public QuadRenderTexture(float minX, float miny, float maxX, float maxY,  Texture texture) {
        this(minX, miny, maxX, maxY, 0, 0, 1, 1, texture);
    }

    public QuadRenderTexture(float minX, float miny, float maxX, float maxY, float uvMinX, float uvMinY, float uvMaxX, float uvMaxY, Texture texture) {
        super();
        this.minX = minX;
        this.miny = miny;
        this.maxX = maxX;
        this.maxY = maxY;
        this.uvMinX = uvMinX;
        this.uvMinY = uvMinY;
        this.uvMaxX = uvMaxX;
        this.uvMaxY = uvMaxY;
        this.texture = texture;
    }

    @Override
    public void render() {
        super.render();

        Vector3f XY = getTransform().getPosition();
        Vector2f scale = getTransform().getScale().XY();

        RectanglePrimitive.render((minX * scale.getX() + XY.getX()), (miny) * scale.getY() + XY.getY(), (maxX * scale.getX() + XY.getX()), (maxY * scale.getY() + XY.getY()), XY.getZ(), uvMinX, uvMinY, uvMaxX, uvMaxY, texture);
    }


    public float getMinX() {
        return minX;
    }

    public void setMinX(float minX) {
        this.minX = minX;
    }

    public float getMiny() {
        return miny;
    }

    public void setMiny(float miny) {
        this.miny = miny;
    }

    public float getMaxX() {
        return maxX;
    }

    public void setMaxX(float maxX) {
        this.maxX = maxX;
    }

    public float getMaxY() {
        return maxY;
    }

    public void setMaxY(float maxY) {
        this.maxY = maxY;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
