package com.threesidedsquare.engine2D.object;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.math.Vector2f;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.object.component.GameComponent;
import com.threesidedsquare.engine2D.object.component.rendering.RenderBounding;
import com.threesidedsquare.engine2D.physics.AABB;
import com.threesidedsquare.engine2D.rendering.Window;
import com.threesidedsquare.engine2D.rendering.primitive.RectanglePrimitive;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.glMatrixMode;

public class GameCamera extends GameObject{

    private double left;
    private double right;
    private double up;
    private double down;
    private double zNear;
    private double zFar;

    private Vector3f oldPos_;
    private AABB frustum;

    public GameCamera() {
        this(-Window.getWidth()/2, Window.getWidth()/2, Window.getHeight()/2, -Window.getHeight()/2, -1, 1);
    }

    public GameCamera(double left, double right, double up, double down, double zNear, double zFar) {
        super();
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
        this.zNear = zNear;
        this.zFar = zFar;
        this.oldPos_ = getTransform().getPosition();

        this.frustum = new AABB((float) left - 150f, (float) down - 150f, (float) right + 150f, (float) up + 150f);

        //addComponent(new RenderBounding(0, 1, 1, RectanglePrimitive.NO_ALPHA, frustum));
        getTransform().getPosition().setZ(1f);
    }


    public void useView(){
        glMatrixMode(GL_PROJECTION_MATRIX);
        glLoadIdentity();
        glOrtho(left, right, down, up, zNear, zFar);
        glMatrixMode(GL_MODELVIEW);
    }

    @Override
    public void update(float delta) {
        oldPos_ = getTransform().getPosition();
        getTransform().setPosition(getTransform().getPosition().add(new Vector3f(5f, 5f, 0)));
        super.update(delta);


    }

    @Override
    public void updateAABB() {
        super.updateAABB();
        frustum.update(getTransform().getPosition().XY(), false);
//        Logging.printLog("Updating frustum");
    }

    public void tranformView(){
        Vector2f curentPos = getTransform().getPosition().XY();
        float x = (oldPos_.getX() - curentPos.getX());
        float y = (oldPos_.getY() - curentPos.getY());
        glTranslatef(x, y, 0);
    }

    @Override
    public void render() {
                Vector3f pos = getTransform().getPosition();
//        glTranslatef(-pos.getX(), -pos.getY(), 0);
        super.render();

        glDisable(GL_BLEND);
        glColor3f(1, 0, 0);

//        Logging.printLog("Drawing frustum - " + frustum);

        glBegin(GL_LINES);
        {
            glVertex3f(frustum.getMinX(), frustum.getMinY(), pos.getZ());
            glVertex3f(frustum.getMinX(), frustum.getMaxY(), pos.getZ());
            glVertex3f(frustum.getMinX(), frustum.getMaxY(), pos.getZ());
            glVertex3f(frustum.getMaxX(), frustum.getMaxY(), pos.getZ());
            glVertex3f(frustum.getMaxX(), frustum.getMaxY(), pos.getZ());
            glVertex3f(frustum.getMaxX(), frustum.getMinY(), pos.getZ());
            glVertex3f(frustum.getMaxX(), frustum.getMinY(), pos.getZ());
            glVertex3f(frustum.getMinX(), frustum.getMinY(), pos.getZ());
        }
        glEnd();
        glEnable(GL_BLEND);
//        glTranslatef(pos.getX(), pos.getY(), 0);
    }

    public AABB getFrustum() {
        return frustum;
    }

    public void setFrustum(AABB frustum) {
        this.frustum = frustum;
    }
}
