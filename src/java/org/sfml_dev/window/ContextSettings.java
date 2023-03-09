package org.sfml_dev.window;

public class ContextSettings {
    
    public static final int DEFAULT = 0;
    public static final int CORE = 1 << 0;
    public static final int DEBUG = 1 << 2;

    public int depthBits;
    public int stencilBits;
    public int antialiasingLevel;
    public int majorVersion;
    public int minorVersion;
    public int attributeFlags;
    public boolean sRgbCapable;

    public ContextSettings() {
        this(0, 0, 0, 1, 1, DEFAULT, false);
    }

    public ContextSettings(int depth) {
        this(depth, 0, 0, 1, 1, DEFAULT, false);
    }

    public ContextSettings(int depth, int stencil) {
        this(depth, stencil, 0, 1, 1, DEFAULT, false);
    }

    public ContextSettings(int depth, int stencil, int antialiasing) {
        this(depth, stencil, antialiasing, 1, 1, DEFAULT, false);
    }

    public ContextSettings(int depth, int stencil, int antialiasing, int major) {
        this(depth, stencil, antialiasing, major, 1, DEFAULT, false);
    }

    public ContextSettings(int depth, int stencil, int antialiasing, int major, int minor) {
        this(depth, stencil, antialiasing, major, minor, DEFAULT, false);
    }

    public ContextSettings(int depth, int stencil, int antialiasing, int major, int minor, int attributes) {
        this(depth, stencil, antialiasing, major, minor, attributes, false);
    }

    public ContextSettings(int depth, int stencil, int antialiasing, int major, int minor, int attributes, boolean sRgb) {
        this.depthBits = depth;
        this.stencilBits = stencil;
        this.antialiasingLevel = antialiasing;
        this.majorVersion = major;
        this.minorVersion = minor;
        this.attributeFlags = attributes;
        this.sRgbCapable = sRgb;
    }

    public String toString() {
        return "{depthBits=" + depthBits +
                ", stencilBits=" + stencilBits +
                ", antialiasingLevel=" + antialiasingLevel +
                ", majorVersion=" + majorVersion +
                ", minorVersion=" + minorVersion +
                ", attributeFlags=" + attributeFlags +
                ", sRgbCapable=" + sRgbCapable + "}";
    }
}
