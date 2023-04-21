package org.sfml_dev.system;

public class Vector2f implements Cloneable {

    /** X coordinate of the vector */
    public float x;

    /** Y coordinate of the vector */
    public float y;

    public Vector2f() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f negate() {
        return new Vector2f(-this.x, -this.y);
    }

    public Vector2f add(Vector2f val) {
        return new Vector2f(this.x + val.x, this.y + val.y);
    }

    public Vector2f subtract(Vector2f val) {
        return new Vector2f(this.x - val.x, this.y - val.y);
    }

    public Vector2f multiply(float val) {
        return new Vector2f(this.x * val, this.y * val);
    }

    public Vector2f divide(float val) {
        return new Vector2f(this.x / val, this.y / val);
    }

    public boolean equals(Object val) {
        if (val instanceof Vector2f vector2f) {
            return (this.x == vector2f.x) && (this.y == vector2f.y);
        }
        return false;
    }

    public Vector2f clone() {
        return new Vector2f(this.x, this.y);
    }

    public String toString() {
        return "{x=" + x + ", y=" + y + "}";
    }
}
