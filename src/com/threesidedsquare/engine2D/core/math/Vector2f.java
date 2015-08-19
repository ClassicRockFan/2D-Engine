package com.threesidedsquare.engine2D.core.math;

public class Vector2f {

    private float x;
    private float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Vector2f add(Vector2f other){
        return new Vector2f(x + other.getX(), y + other.getY());
    }

    public Vector2f sub(Vector2f other){
        return new Vector2f(x - other.getX(), y - other.getY());
    }

    public Vector2f mul(Vector2f other){
        return new Vector2f(x * other.getX(), y * other.getY());
    }

    public Vector2f div(Vector2f other){
        return new Vector2f(x / other.getX(), y / other.getY());
    }

    public Vector2f add(float other){
        return new Vector2f(x + other, y + other);
    }

    public Vector2f sub(float other){
        return new Vector2f(x - other, y - other);
    }

    public Vector2f mul(float other){
        return new Vector2f(x * other, y * other);
    }

    public Vector2f div(float other){
        return new Vector2f(x / other, y / other);
    }

    public float length(){
        return (x + y);
    }

    public Vector2f normalized(){
        float length = length();
        if(length == 0)
            return new Vector2f(1, 1);

        float x_ = x / length;
        float y_ = y / length;

        return new Vector2f(x_, y_);
    }

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

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
