package com.threesidedsquare.engine2D.core;

public abstract class GameComponent {

    private GameObject parent;

    public void input(){

    }

    public void update(){

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
