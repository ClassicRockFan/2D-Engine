package com.threesidedsquare.engine2D.object.component.rendering;

import com.threesidedsquare.engine2D.object.component.GameComponent;
import com.threesidedsquare.engine2D.physics.AABB;
import com.threesidedsquare.engine2D.rendering.primitive.RectanglePrimitive;

public class RenderBounding extends GameComponent{

    private float r;
    private float g;
    private float b;
    private float a;
    private AABB bounding;



    public RenderBounding(float r, float g, float b) {
        this(r , g, b, RectanglePrimitive.NO_ALPHA);
    }

    public RenderBounding(float r, float g, float b, float a) {
        this(r, g, b, a, null);
    }

    public RenderBounding(float r, float g, float b, float a, AABB bounding) {
        super();
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        this.bounding = bounding;
    }

    @Override
    public void render() {
        super.render();

        if(bounding == null)
            bounding = getParent().getAabb();

        RectanglePrimitive.render(bounding.getMinX(), bounding.getMinY(), bounding.getMaxX(), bounding.getMaxY(), getTransform().getPosition().getZ(), r, g, b, a);

    }
}
