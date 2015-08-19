package com.threesidedsquare.engine2D.physics;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.math.Vector2f;

public class AABB {


    private float minX;
    private float minY;
    private float maxX;
    private float maxY;

    private Vector2f center;

    public AABB(Vector2f min, Vector2f max){
        this(min.getX(), min.getY(), max.getX(), max.getY());
    }

    public AABB(float minX, float minY, float maxX, float maxY) {
        float minX_ = minX;
        float maxX_ = maxX;
        float minY_ = minY;
        float maxY_ = maxY;

        if(minX > maxX){
            minX_ = maxX;
            maxX_ = minX;
        }

        if(minY > maxY){
            minY_ = maxY;
            maxY_ = minY;
        }

        this.minX = minX_;
        this.minY = minY_;
        this.maxX = maxX_;
        this.maxY = maxY_;
        this.center = getCalculatedCenter();
    }

    public static AABB generateFromCorner(Vector2f corner, float width, float height){
        int minX_ = width > 0 ? 1 : -1;
        int minY_ = height > 0 ? 1 : -1;

        float cornerX = corner.getX() * minX_;
        float cornerY = corner.getY() * minY_;

        AABB result = new AABB(cornerX, cornerY, width + cornerX, height + cornerY);
        result.update(result.getCalculatedCenter());
        return result;
    }

    public static AABB generateFromCenter(Vector2f center, float width, float height){
        float halfWidth = width/2;
        float halfHeight = height /2;

        //Logging.printLog("Generating new AABB from center: " + center);

        Vector2f max = center.add(new Vector2f(halfWidth, halfHeight));
        Vector2f min = center.sub(new Vector2f(halfWidth, halfHeight));

        return new AABB(min, max);
    }

    public AABB[] subdivide(){
//        Logging.printLog("original - " + toString());

        AABB[] result = new AABB[4];
        Vector2f center = getCalculatedCenter();

        float width = getWidth()/2;
        float height = getHeight()/2;

        result[0] = generateFromCenter(center.add(new Vector2f(width/2, height/2)), width, height);
        result[1] = generateFromCenter(center.add(new Vector2f(-width/2, height/2)), -width, height);
        result[2] = generateFromCenter(center.add(new Vector2f(-width/2, -height/2)), -width, -height);
        result[3] = generateFromCenter(center.add(new Vector2f(width/2, -height/2)), width, -height);

//        for(int i = 0; i < 4; i++) {
//            Logging.printLog(i + " - " + result[i].toString());
//        }
        return result;
    }

    public void update(Vector2f pos, boolean print){
        if(print)
            Logging.printLog("OLd aabb - " + this);
        AABB newAABB = generateFromCenter(pos, getWidth(), getHeight());

        minX = newAABB.minX;
        minY = newAABB.minY;
        maxX = newAABB.maxX;
        maxY = newAABB.maxY;

        center = pos;

        if(print)
            Logging.printLog("new AABB - " + this);
    }

    public void update(Vector2f pos){
        update(pos, false);
    }

    public boolean doesIntersect(AABB other){
        return doesIntersect(other, false);
    }

    public boolean doesIntersect(AABB other, boolean print){
        if(other == null){
            return false;
        }

        if((other.getCenter().getX() <= maxX && other.getCenter().getX() >= minX &&
                other.getCenter().getY() <= maxY && other.getCenter().getY() >= minY)){
            if(print)
                Logging.printLog("INSIDE");
            return true;
        }

        if((minX <= other.getMaxX() && maxX >= other.getMinX() &&
                minY <= other.getMaxY() && maxY >= other.getMinY())
                )
            return true;
//
//        Vector2f otherCenter = other.getCenter();
//        float otherRadius = new Vector2f(other.getWidth(), other.getHeight()).length();
//
//        Vector2f thisCenter = getCenter();
//        float thisRadius = new Vector2f(getWidth(), getHeight()).length();
//
//        float distance = otherCenter.sub(thisCenter).length();


        //return distance < (otherRadius + thisRadius);

        if(print) {
            System.out.println("Failure reasons: ");
            System.out.println("Condition one - minX < other.getMaxX() - " + (minX < other.getMaxX()));
            System.out.println("Minx of this - " + minX);
            System.out.println(" maxX of other - " + other.getMaxX());
            System.out.println("Condition two - maxX > other.getMinX() - " + (maxX > other.getMinX()));
            System.out.println("maxX of this - " + maxX);
            System.out.println(" minX of other - " + other.getMinX());
            System.out.println("Condition three - minY < other.getMaxY() - " + (minY < other.getMaxY()));
            System.out.println("minY of this - " + minY + " - maxY of other - " + other.getMaxY());
            System.out.println("Condition four - maxY > other.getMinY() - " + (maxY > other.getMinY()));
            System.out.println("maxy of this - " + maxY + " - minY of other - " + other.getMinY());
        }

        return false;
    }
    public Vector2f getCalculatedCenter(){
        return new Vector2f((maxX + minX) / 2, (maxY + minY)/2);
    }

    public Vector2f getCenter() {
        return center;
    }

    public void setCenter(Vector2f center) {
        this.center = center;
    }

    public float getMinX() {
        return minX;
    }

    public float getMinY() {
        return minY;
    }

    public float getMaxX() {
        return maxX;
    }

    public float getMaxY() {
        return maxY;
    }

    public float getWidth(){
        return maxX - minX;
    }

    public float getHeight(){
        return maxY - minY;
    }

    @Override
    public String toString() {
        return "[width] = " + getWidth() + " [height] = " + getHeight() + " [calculatedCenter] = " + getCalculatedCenter() + " [actualCenter] = " + center + " [minExtents] = " + new Vector2f(minX, minY) + " [maxExtents] = " + new Vector2f(maxX, maxY);
    }
}
