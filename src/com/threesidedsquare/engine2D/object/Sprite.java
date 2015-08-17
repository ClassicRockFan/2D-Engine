package com.threesidedsquare.engine2D.object;

import com.threesidedsquare.engine2D.object.component.rendering.QuadRenderTexture;
import com.threesidedsquare.engine2D.rendering.Texture;

public class Sprite extends GameObject{

    private Texture texture;
    private QuadRenderTexture mainComponent;

    public Sprite(String path){
        this(new Texture(path));
    }

    public Sprite(Texture texture) {
        super();
        this.texture = texture;

        mainComponent = new QuadRenderTexture(0, 0, texture.getWidth(), texture.getHeight(), texture);
        addComponent(mainComponent);
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
        getComponents().remove(mainComponent);
        mainComponent = new QuadRenderTexture(-texture.getWidth()/2, -texture.getHeight()/2, texture.getWidth()/2, texture.getHeight()/2, texture);
        addComponent(mainComponent);
    }
}
