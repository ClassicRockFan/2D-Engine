package com.threesidedsquare.engine2D.core.math;

public class Vector3f {

    private float x;
    private float y;
    private float z;

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3f add(Vector3f other){
        return new Vector3f(x + other.getX(), y + other.getY(), z + other.getZ());
    }

    public Vector3f sub(Vector3f other){
        return new Vector3f(x - other.getX(), y - other.getY(), z - other.getZ());
    }

    public Vector3f mul(Vector3f other){
        return new Vector3f(x * other.getX(), y * other.getY(), z * other.getZ());
    }


    public Vector3f div(Vector3f other){
        return new Vector3f(x / other.getX(), y / other.getY(), z / other.getZ());
    }

    public float length(){
        return (x + y + z);
    }

    public Vector3f normalized(){
        float length = length();

        float x_ = x / length;
        float y_ = y / length;
        float z_ = z / length;

        return new Vector3f(x_, y_, z_);
    }

    //Swizzling
    public Vector2f XZ(){
        return new Vector2f(x, z);
    }
    public Vector2f ZX(){
        return new Vector2f(z, x);
    }

    public Vector2f XY(){
        return new Vector2f(x, y);
    }
    public Vector2f YX(){
        return new Vector2f(y, x);
    }

    public Vector2f YZ(){
        return new Vector2f(y, z);
    }
    public Vector2f ZY(){
        return new Vector2f(z, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    //Getters and Setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
