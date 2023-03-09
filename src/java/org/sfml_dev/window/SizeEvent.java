package org.sfml_dev.window;

public class SizeEvent extends Event {
    public int width;
    public int height;

    public SizeEvent(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
