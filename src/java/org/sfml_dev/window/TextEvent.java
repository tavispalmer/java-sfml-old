package org.sfml_dev.window;

public class TextEvent extends Event {
    public int unicode;

    public TextEvent(int unicode) {
        this.unicode = unicode;
    }
}
