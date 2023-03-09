package org.sfml_dev.window;

public class MouseWheelScrollEvent extends Event {
    
    public Mouse.Wheel wheel;
    public float delta;
    public int x;
    public int y;

    public MouseWheelScrollEvent(Mouse.Wheel wheel, float delta, int x, int y) {
        this.wheel = wheel;
        this.delta = delta;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{wheel=" + wheel +
                ", delta=" + delta +
                ", x=" + x +
                ", y=" + y + "}";
    }
}
