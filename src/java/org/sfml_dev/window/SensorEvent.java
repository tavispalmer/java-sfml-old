package org.sfml_dev.window;

public class SensorEvent extends Event {
    public Sensor.Type type;
    public float x;
    public float y;
    public float z;

    public SensorEvent(Sensor.Type type, float x, float y, float z) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return "{type=" + type +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z + "}";
    }
}
