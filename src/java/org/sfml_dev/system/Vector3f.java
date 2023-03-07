package org.sfml_dev.system;

public class Vector3f {

    /** X coordinate of the vector */
    public float x;

    /** Y coordinate of the vector */
    public float y;

    /** Z coordinate of the vector */
    public float z;

    public Vector3f() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f negate() {
        return new Vector3f(-this.x, -this.y, -this.z);
    }

    public Vector3f add(Vector3f val) {
        return new Vector3f(this.x + val.x, this.y + val.y, this.z + val.z);
    }

    public Vector3f subtract(Vector3f val) {
        return new Vector3f(this.x - val.x, this.y - val.y, this.z - val.z);
    }

    public Vector3f multiply(float val) {
        return new Vector3f(this.x * val, this.y * val, this.z * val);
    }

    public Vector3f divide(float val) {
        return new Vector3f(this.x / val, this.y / val, this.z / val);
    }

    public boolean equals(Object val) {
        if (val instanceof Vector3f vector3f) {
            return (this.x == vector3f.x) && (this.y == vector3f.y) && (this.z == vector3f.z);
        }
        return false;
    }
}
