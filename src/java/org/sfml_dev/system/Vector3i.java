package org.sfml_dev.system;

public class Vector3i {

    /** X coordinate of the vector */
    public int x;

    /** Y coordinate of the vector */
    public int y;

    /** Z coordinate of the vector */
    public int z;

    public Vector3i() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3i negate() {
        return new Vector3i(-this.x, -this.y, -this.z);
    }

    public Vector3i add(Vector3i val) {
        return new Vector3i(this.x + val.x, this.y + val.y, this.z + val.z);
    }

    public Vector3i subtract(Vector3i val) {
        return new Vector3i(this.x - val.x, this.y - val.y, this.z - val.z);
    }

    public Vector3i multiply(int val) {
        return new Vector3i(this.x * val, this.y * val, this.z * val);
    }

    public Vector3i divide(int val) {
        return new Vector3i(this.x / val, this.y / val, this.z / val);
    }

    public boolean equals(Object val) {
        if (val instanceof Vector3i vector3i) {
            return (this.x == vector3i.x) && (this.y == vector3i.y) && (this.z == vector3i.z);
        }
        return false;
    }
}
