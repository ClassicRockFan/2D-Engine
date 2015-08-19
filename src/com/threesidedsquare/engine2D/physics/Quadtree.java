package com.threesidedsquare.engine2D.physics;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.math.Vector2f;
import com.threesidedsquare.engine2D.object.GameObject;

import java.util.HashSet;
import java.util.Set;

public class Quadtree {
    public static final int NUM_TO_STORE = 6;

    private AABB bounding;
    private GameObject[] objects;
    private Quadtree[] children;
    private int numStored;
    private int depth;

    public Quadtree(AABB bounding, int depth) {
        this.bounding = bounding;
        this.children = new Quadtree[4];
        this.objects = new GameObject[NUM_TO_STORE];
        this.numStored = 0;
        this.depth = depth;
//        Logging.printLog("New Quadtree " + toString() );
    }

    private Quadtree(AABB bounding, int depth, Quadtree[] children, GameObject[] objects, int numStored){
        this.bounding = bounding;
        this.depth = depth;
        this.children = children;
        this.objects = objects;
        this.numStored = numStored;
    }

    public Set<GameObject> queryAll(){
        return queryRange(bounding);
    }

    public Set<GameObject> queryRange(AABB range){
        return queryRange(range, new HashSet<GameObject>());
    }

    public Set<GameObject> queryRange(AABB range, Set<GameObject> result){
        if(range.doesIntersect(bounding)){
            if(children[0] != null)
                for(int i = 0; i < 4; i++){
                    children[i].queryRange(range, result);
                }

            for(int i = 0; i < numStored; i++){
                result.add(objects[i]);
            }
        }

        return result;
    }

    public String add(GameObject object){
        if(bounding.doesIntersect(object.getAabb())) {

            if (numStored < NUM_TO_STORE) {
                objects[numStored] = object;
                numStored++;
                return "added child at depth " + depth;
            }

            if (children[0] == null) {
                //Logging.printLog("SUBDIVIDING");
                AABB[] newBoundings = bounding.subdivide();
                children[0] = new Quadtree(newBoundings[0], depth + 1);
                children[1] = new Quadtree(newBoundings[1], depth + 1);
                children[2] = new Quadtree(newBoundings[2], depth + 1);
                children[3] = new Quadtree(newBoundings[3], depth + 1);
            }

            //Logging.printLog("OBJECT AABB: " + object.getAabb());
            for (int i = 0; i < 4; i++) {
                if (children[i] == null) {
                    Logging.printLog("NULL CHILD!!!!!", Logging.LEVEL_ERROR);
                    System.exit(-2);
                }

                //  Logging.printLog(i + " - " + children[i].getBounding().toString());
                if (children[i].getBounding().doesIntersect(object.getAabb()))
                    return "- " + i + " " + children[i].add(object);
            }
        }else {
            Logging.printLog("Expansion success - " + expand(object));
            return " expanded " + add(object);
        }
        Logging.printLog("Failed to add object - " + object.getAabb() + " this aabb - " + bounding);

        for(int i = 0; i < 4; i++) {
            Logging.printLog(i + " - child " + children[i]);
            children[i].getBounding().doesIntersect(object.getAabb(), true);
        }
        return "endLoop";
    }

    private boolean expand(GameObject object){
        depth --;
        Quadtree thisAsNode = new Quadtree(bounding, depth + 1, children, objects, numStored);

        children = new Quadtree[4];
        numStored = 0;
        objects = new GameObject[NUM_TO_STORE];

        Vector2f thisCenter = bounding.getCenter();
        Vector2f otherCenter = object.getAabb().getCenter();
//
//        Logging.printLog("This Center - " + thisCenter);
//        Logging.printLog("Other Center - " + otherCenter);

        boolean left = otherCenter.getX() < thisCenter.getX();
        boolean down = otherCenter.getY() < thisCenter.getY();

        //Logging.printLog("down = " + down + "; left = " + left) ;

        Vector2f newCenter = new Vector2f(0, 0);

        if(left)
            newCenter.setX(bounding.getMinX());
        else
            newCenter.setX(bounding.getMaxX());

        if(down)
            newCenter.setY(bounding.getMinY());
        else
            newCenter.setY(bounding.getMaxY());

        float newWidth = bounding.getWidth() * 2;
        float newHeight = bounding.getHeight() * 2;

        this.bounding = AABB.generateFromCenter(newCenter, newWidth, newHeight);

//        Logging.printLog("New Bounding - " + bounding);
//        Logging.printLog("Correct Expansion - " + bounding.doesIntersect(object.getAabb(), true));

        AABB[] newBoundings = bounding.subdivide();
        children[0] = new Quadtree(newBoundings[0], depth + 1);
        children[1] = new Quadtree(newBoundings[1], depth + 1);
        children[2] = new Quadtree(newBoundings[2], depth + 1);
        children[3] = new Quadtree(newBoundings[3], depth + 1);

        if(thisAsNode.bounding.getCalculatedCenter().getX() > bounding.getCalculatedCenter().getX()){
            if(thisAsNode.bounding.getCalculatedCenter().getY() > bounding.getCalculatedCenter().getY()){
                children[0] = thisAsNode;
            }else {
                children[3] = thisAsNode;
            }
        }else{
            if(thisAsNode.bounding.getCalculatedCenter().getY() > bounding.getCalculatedCenter().getY()){
                children[1] = thisAsNode;
            }else {
                children[2] = thisAsNode;
            }
        }

        return bounding.doesIntersect(object.getAabb());
    }

    public boolean remove(GameObject object){
        if(bounding.doesIntersect(object.getAabb())){
            for(int i = 0; i < numStored; i++){
                if(objects[i] == object){
                    for(int j = i; j < numStored; j++){
                        if((j + 1) >= NUM_TO_STORE)
                            break;

                        objects[j] = objects[j + 1];
                    }
                    objects[numStored - 1] = null;
                    numStored--;

                    return true;
                }
            }

            for(int i2 = 0; i2 < 4; i2 ++){
                if(children[i2] != null)
                    if(children[i2].remove(object))
                        return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "[depth] - " + depth + " " + bounding;
    }

    public AABB getBounding() {
        return bounding;
    }

    public GameObject[] getObjects() {
        return objects;
    }

    public Quadtree[] getChildren() {
        return children;
    }

    public int getNumStored() {
        return numStored;
    }
}
