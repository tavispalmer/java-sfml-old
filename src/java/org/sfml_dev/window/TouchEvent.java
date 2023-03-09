package org.sfml_dev.window;

public class TouchEvent extends Event {
    
    public int finger;
    public int x;
    public int y;

    public TouchEvent(int finger, int x, int y) {
        this.finger = finger;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{finger=" + finger +
                ", x=" + x +
                ", y=" + y + "}";
    }
}
