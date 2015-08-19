package com.threesidedsquare.engine2D.core;

import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.object.GameObject;

public class Transform {

    private Vector3f position;
    private Vector3f scale;
    private GameObject parent;

    public Transform(GameObject parent) {
        this(parent, new Vector3f(0, 0, 0), new Vector3f(1, 1, 1));
    }

    public Transform(GameObject parent, Vector3f position, Vector3f scale) {
        this.parent = parent;
        this.position = position;
        this.scale = scale;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
        parent.getAabb().update(position.XY());
    }

    public Vector3f getScale() {
        return scale;
    }

    public void setScale(Vector3f scale) {
        this.scale = scale;
    }
}
