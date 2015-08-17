package com.threesidedsquare.engine2D.object;

import com.threesidedsquare.engine2D.core.Transform;
import com.threesidedsquare.engine2D.object.component.GameObject;

public abstract class GameComponent {

    private GameObject parent;

    public void input(float delta){

    }

    public void update(float delta){

    }

    public void render(){

    }

    public GameObject getParent() {
        return parent;
    }

    public void setParent(GameObject parent) {
        this.parent = parent;
    }

    public Transform getTransform(){
        return parent.getTransform();
    }
}
