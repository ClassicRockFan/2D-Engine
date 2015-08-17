package com.threesidedsquare.engine2D.physics;

import com.threesidedsquare.engine2D.core.CoreEngine;
import com.threesidedsquare.engine2D.object.GameObject;

import java.util.ArrayList;

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

        for(int i = 0; i < components.size(); i++){
            for(int j = i + 1; j < components.size(); j++){
                if(components.get(i).getParent().getAabb().doesIntersect(components.get(j).getParent().getAabb())){
                    components.get(i).respond(delta);
                    components.get(j).respond(delta);
                }
            }
        }
    }
}
