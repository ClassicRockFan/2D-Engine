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

        Vector3f XY = getTransform().getPosition();
        Vector2f scale = getTransform().getScale().XY();

        RectanglePrimitive.render((minX * scale.getX() + XY.getX()), (miny) * scale.getY() + XY.getY(), (maxX * scale.getX() + XY.getX()), (maxY * scale.getY() + XY.getY()), XY.getZ(), texture);
    }

}
