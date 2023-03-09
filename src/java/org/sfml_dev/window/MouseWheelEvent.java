package org.sfml_dev.window;

public class MouseWheelEvent extends Event {
    public int delta;
    public int x;
    public int y;

    public MouseWheelEvent(int delta, int x, int y) {
        this.delta = delta;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{delta=" + delta +
                ", x=" + x +
                ", y=" + y + "}";
    }
}
