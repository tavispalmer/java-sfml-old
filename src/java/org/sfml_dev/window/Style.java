package org.sfml_dev.window;

public class Style {
    public static final int NONE = 0;
    public static final int TITLEBAR = 1 << 0;
    public static final int RESIZE = 1 << 1;
    public static final int CLOSE = 1 << 2;
    public static final int FULLSCREEN = 1 << 3;

    public static final int DEFAULT = TITLEBAR | RESIZE | CLOSE;

    private Style() {}
}
