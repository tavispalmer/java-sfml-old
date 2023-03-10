package org.sfml_dev.window;

public class MouseMoveEvent extends Event {
    public int x;
    public int y;

    public MouseMoveEvent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{x=" + x +
                ", y=" + y + "}";
    }
}
