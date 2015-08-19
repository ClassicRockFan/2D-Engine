package com.threesidedsquare.engine2D.object;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.Input;
import com.threesidedsquare.engine2D.core.math.Vector2f;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.object.component.rendering.QuadRenderTexture;
import com.threesidedsquare.engine2D.object.component.rendering.RenderBounding;
import com.threesidedsquare.engine2D.physics.AABB;
import com.threesidedsquare.engine2D.rendering.Texture;
import com.threesidedsquare.engine2D.rendering.Window;
import com.threesidedsquare.engine2D.rendering.primitive.RectanglePrimitive;

public abstract class MenuButton extends GameObject{


    public MenuButton(AABB aabb, Texture texture) {
        super(aabb);
        addComponent(new QuadRenderTexture(aabb.getMinX(), aabb.getMinY(), aabb.getMaxX(), aabb.getMaxY(), texture));
        Vector2f center = aabb.getCalculatedCenter();
        getTransform().setPosition(new Vector3f(center.getX(), center.getY(), getTransform().getPosition().getZ()));
    }

    @Override
    public void input(float delta) {
        super.input(delta);

        if(Input.getMouseDown(0)){
            Vector2f cameraPos = getScene().getGame().getEngine().getRenderingEngine().getCamera().getTransform().getPosition().XY();
            Vector2f mousePos = Input.getMousePosition();//.add(cameraPos).add(new Vector2f((float)(Window.getWidth()/2), (float)(Window.getHeight()/2)));
            //Logging.printLog("aabb - " + getAabb());
            //Logging.printLog("Mouse Pos - " + mousePos);

            //x-conversion
            if(mousePos.getX() <= (Window.getWidth()/2)){
                mousePos.setX(new Vector2f((float)(Window.getWidth()/2), 0).sub(new Vector2f(mousePos.getX(), 0)).mul(new Vector2f(-1, 1)).getX());
            }else{
                mousePos.setX(new Vector2f((float)(Window.getWidth()/2), 0).sub(new Vector2f((float)(Window.getWidth()), 0).sub(new Vector2f(mousePos.getX(), 0))).getX());
            }

            //Y-conversion
            if(mousePos.getY() <= (Window.getHeight()/2)){
                mousePos.setY(new Vector2f(0, (float) (Window.getHeight() / 2)).sub(new Vector2f(0, mousePos.getY())).mul(new Vector2f(1, -1)).getY());
            }else{
                mousePos.setY(mousePos.sub(new Vector2f(0, (float)(Window.getHeight()/2))).getY());
            }

            mousePos = mousePos.add(cameraPos);
            Logging.printLog("Mouse pos corrected - " + mousePos);
            if(mousePos.getX() >= getAabb().getMinX() && mousePos.getX() <= getAabb().getMaxX() &&
                    mousePos.getY() >= getAabb().getMinY() && mousePos.getY() <= getAabb().getMaxY())
                handle(delta);
        }
    }

    public abstract void handle(float delta);
}
