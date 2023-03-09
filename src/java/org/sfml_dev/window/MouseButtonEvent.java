package org.sfml_dev.window;

public class MouseButtonEvent extends Event {
    
    public Mouse.Button button;
    public int x;
    public int y;

    public MouseButtonEvent(Mouse.Button button, int x, int y) {
        this.button = button;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{button=" + button +
                ", x=" + x +
                ", y=" + y + "}";
    }
}
