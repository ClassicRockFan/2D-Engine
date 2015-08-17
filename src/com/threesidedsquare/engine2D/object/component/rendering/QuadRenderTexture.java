package com.threesidedsquare.engine2D.object.component.rendering;

import com.threesidedsquare.engine2D.core.math.Vector2f;
import com.threesidedsquare.engine2D.object.GameComponent;
import com.threesidedsquare.engine2D.rendering.Texture;
import com.threesidedsquare.engine2D.rendering.primitive.RectanglePrimitive;

public class QuadRenderTexture extends GameComponent{

    private float minX;
    private float miny;
    private float maxX;
    private float maxY;
    private Texture texture;

    public QuadRenderTexture(float minX, float miny, float maxX, float maxY, Texture texture) {
        super();
        this.minX = minX;
        this.miny = miny;
        this.maxX = maxX;
        this.maxY = maxY;
        this.texture = texture;
    }

    @Override
    public void render() {
        super.render();

        Vector2f XY = getTransform().getPosition().XY();

        RectanglePrimitive.render(minX + XY.getX(), miny + XY.getY(), maxX + XY.getX(), maxY + XY.getY(), texture);
    }

}
