package com.threesidedsquare.engine2D.object.component.rendering;

import com.threesidedsquare.engine2D.object.component.GameComponent;
import com.threesidedsquare.engine2D.physics.AABB;
import com.threesidedsquare.engine2D.rendering.primitive.RectanglePrimitive;

public class RenderBounding extends GameComponent{

    private float r;
    private float g;
    private float b;

    public RenderBounding(float r, float g, float b) {
        super();
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public void render() {
        super.render();

        AABB aabb = getParent().getAabb();

        RectanglePrimitive.render(aabb.getMinX(), aabb.getMinY(), aabb.getMaxX(), aabb.getMaxY(), getTransform().getPosition().getZ(), r, g, b);

    }
}
