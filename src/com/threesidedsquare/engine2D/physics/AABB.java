package com.threesidedsquare.engine2D.physics;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.math.Vector2f;

public class AABB {

    private Vector2f minExtents;
    private Vector2f maxExtents;
    private Vector2f center;

    public AABB(float minX, float minY, float maxX, float maxY){
        this(new Vector2f(minX, minY), new Vector2f(maxX, maxY));
    }

    public AABB(Vector2f minExtents, Vector2f maxExtents) {
        this.minExtents = minExtents;
        this.maxExtents = maxExtents;

        this.center = minExtents.add(maxExtents).div(new Vector2f(2, 2));
    }

    public void update(Vector2f pos){
        setCenter(pos);
    }

    public boolean doesIntersect(AABB other){
        Vector2f thisMin = minExtents.add(center);
        Vector2f thisMax = maxExtents.add(center);
        Vector2f otherMin = other.minExtents.add(other.center);
        Vector2f otherMax = other.maxExtents.add(other.center);

//        Logging.printLog("This Min = " + thisMin.toString());
//        Logging.printLog("This Max = " + thisMax.toString());
//        Logging.printLog("Other Min = " + otherMin.toString());
//        Logging.printLog("Other Max = " + otherMax.toString());

        if(thisMin.getX() < otherMax.getX() &&
                thisMax.getX() > otherMin.getX() &&
                thisMin.getY() < otherMax.getY() &&
                thisMax.getY() > otherMin.getY()
                )
            return true;

        return false;
    }

    public Vector2f getMinExtents() {
        return minExtents;
    }

    public void setMinExtents(Vector2f minExtents) {
        this.minExtents = minExtents;
    }

    public Vector2f getMaxExtents() {
        return maxExtents;
    }

    public void setMaxExtents(Vector2f maxExtents) {
        this.maxExtents = maxExtents;
    }

    public Vector2f getCenter() {
        return center;
    }

    public void setCenter(Vector2f center) {
        this.center = center;
    }
}
