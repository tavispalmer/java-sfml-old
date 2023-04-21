package org.sfml_dev.system;

public class Vector2i implements Cloneable {

    /** X coordinate of the vector */
    public int x;

    /** Y coordinate of the vector */
    public int y;

    public Vector2i() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2i negate() {
        return new Vector2i(-this.x, -this.y);
    }

    public Vector2i add(Vector2i val) {
        return new Vector2i(this.x + val.x, this.y + val.y);
    }

    public Vector2i subtract(Vector2i val) {
        return new Vector2i(this.x - val.x, this.y - val.y);
    }

    public Vector2i multiply(int val) {
        return new Vector2i(this.x * val, this.y * val);
    }

    public Vector2i divide(int val) {
        return new Vector2i(this.x / val, this.y / val);
    }

    public boolean equals(Object val) {
        if (val instanceof Vector2i vector2i) {
            return (this.x == vector2i.x) && (this.y == vector2i.y);
        }
        return false;
    }

    public Vector2i clone() {
        return new Vector2i(this.x, this.y);
    }

    public String toString() {
        return "{x=" + x + ", y=" + y + "}";
    }
}
