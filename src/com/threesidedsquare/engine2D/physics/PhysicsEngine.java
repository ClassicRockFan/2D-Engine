package com.threesidedsquare.engine2D.physics;

import com.threesidedsquare.engine2D.core.CoreEngine;
import com.threesidedsquare.engine2D.object.GameObject;
import com.threesidedsquare.engine2D.object.component.GameComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class PhysicsEngine {

    private CoreEngine engine;

    public PhysicsEngine(CoreEngine engine) {
        this.engine = engine;
    }

    public void doPhysics(float delta){
        ArrayList<GameObject> contestants = engine.getGame().getActiveScene().getObjects();
        ArrayList<PhysicsComponent> components = new ArrayList<>();

        for(GameObject object : contestants)
            if(object.getPhysicsComponent() != null)
                components.add(object.getPhysicsComponent());

        for(PhysicsComponent component : components)
            component.simulate(delta);

        for(PhysicsComponent component : components){
            Iterator collisions = engine.getGame().getActiveScene().getQuadtree().queryRange(component.getParent().getAabb()).iterator();
            if(!collisions.hasNext())
                continue;

            while (collisions.hasNext()){
                GameObject object = (GameObject) collisions.next();

                if (object == component.getParent())
                    continue;

                PhysicsComponent component2 = object.getPhysicsComponent();
                if(component2 != null && component.getParent().getAabb().doesIntersect(component2.getParent().getAabb())){
                    component.respond(delta, component2.getParent());
                    component2.respond(delta, component.getParent());
                }
            }
        }
    }
}
