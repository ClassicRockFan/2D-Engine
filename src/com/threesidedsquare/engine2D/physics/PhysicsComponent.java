package com.threesidedsquare.engine2D.physics;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.math.Vector2f;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.object.GameObject;
import com.threesidedsquare.engine2D.object.component.GameComponent;

public class PhysicsComponent extends GameComponent{

    private Vector2f velocity;
    private Vector2f acceleration;

    public PhysicsComponent(Vector2f velocity, Vector2f acceleration) {
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public void simulate(float delta){
        velocity = velocity.add(acceleration.mul(new Vector2f(delta, delta)));
        Vector2f newPos = velocity.mul(new Vector2f(delta, delta)).add(getTransform().getPosition().XY());
        getTransform().setPosition(new Vector3f(newPos.getX(), newPos.getY(), getTransform().getPosition().getZ()));
        acceleration = new Vector2f(0, 0);
    }

    public void respond(float delta, GameObject other){
//        Logging.printLog("False Positive? - " + other.getAabb().doesIntersect(getParent().getAabb()));

//        Logging.printLog(getParent().toString() + " Collided with AABB " + getParent().getAabb().toString());
        velocity = velocity.mul(new Vector2f(-1f, -1f));

        Vector2f newPos = velocity.mul(new Vector2f(2 * delta, 2 * delta)).add(getTransform().getPosition().XY());
        getTransform().setPosition(new Vector3f(newPos.getX(), newPos.getY(), getTransform().getPosition().getZ()));

//        Logging.printLog("New Velocity - " + velocity.toString());
    }

    @Override
    public void setParent(GameObject parent) {
        super.setParent(parent);
        parent.setPhysicsComponent(this);
    }

    public Vector2f getVelocity() {
        return velocity;
    }

    public void addVelocity(Vector2f add){
        setVelocity(getVelocity().add(add));
    }

    public void setVelocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    public Vector2f getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2f acceleration) {
        this.acceleration = acceleration;
    }
}
