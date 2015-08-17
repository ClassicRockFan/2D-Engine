package com.threesidedsquare.engine2D.object.component.rendering;

import com.threesidedsquare.engine2D.core.math.Vector2f;
import com.threesidedsquare.engine2D.object.GameComponent;
import com.threesidedsquare.engine2D.rendering.primitive.RectanglePrimitive;

public class QuadRender extends GameComponent {

    private float minX;
    private float miny;
    private float maxX;
    private float maxY;
    private float r;
    private float g;
    private float b;

    public QuadRender(float minX, float miny, float maxX, float maxY, float r, float g, float b) {
        super();
        this.minX = minX;
        this.miny = miny;
        this.maxX = maxX;
        this.maxY = maxY;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public void render() {
        super.render();

        Vector2f XY = getTransform().getPosition().XY();

        RectanglePrimitive.render(minX + XY.getX(), miny + XY.getY(), maxX + XY.getX(), maxY + XY.getY(), r, g, b);
    }
}
