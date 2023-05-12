package org.sfml_dev.graphics;

public class Color implements Cloneable {

    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color RED = new Color(255, 0, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color BLUE = new Color(0, 0, 255);
    public static final Color YELLOW = new Color(255, 255, 0);
    public static final Color MAGENTA = new Color(255, 0, 255);
    public static final Color CYAN = new Color(0, 255, 255);
    public static final Color TRANSPARENT = new Color(0, 0, 0, 0);

    public byte r;
    public byte g;
    public byte b;
    public byte a;

    public Color() {
        this.r = 0;
        this.g = 0;
        this.b = 0;
        this.a = (byte)255;
    }

    public Color(int red, int green, int blue) {
        this(red, green, blue, 255);
    }

    public Color(int red, int green, int blue, int alpha) {
        this.r = (byte)red;
        this.g = (byte)green;
        this.b = (byte)blue;
        this.a = (byte)alpha;
    }

    public Color(int color) {
        this.r = (byte)((color & 0xff000000) >>> 24);
        this.g = (byte)((color & 0x00ff0000) >>> 16);
        this.b = (byte)((color & 0x0000ff00) >>> 8 );
        this.a = (byte)((color & 0x000000ff) >>> 0 );
    }

    public int toInteger() {
        return (r << 24) | (g << 16) | (b << 8) | a;
    }
    
    public boolean equals(Object val) {
        if (val instanceof Color color) {
            return (this.r == color.r) &&
                   (this.g == color.g) &&
                   (this.b == color.b) &&
                   (this.a == color.a);
        }
        return false;
    }

    public Color add(Color val) {
        return new Color((byte)Math.min(((int)this.r & 0xff) + ((int)val.r & 0xff), 255),
                         (byte)Math.min(((int)this.g & 0xff) + ((int)val.g & 0xff), 255),
                         (byte)Math.min(((int)this.b & 0xff) + ((int)val.b & 0xff), 255),
                         (byte)Math.min(((int)this.a & 0xff) + ((int)val.a & 0xff), 255));
    }

    public Color subtract(Color val) {
        return new Color((byte)Math.max(((int)this.r & 0xff) - ((int)val.r & 0xff), 0),
                         (byte)Math.max(((int)this.g & 0xff) - ((int)val.g & 0xff), 0),
                         (byte)Math.max(((int)this.b & 0xff) - ((int)val.b & 0xff), 0),
                         (byte)Math.max(((int)this.a & 0xff) - ((int)val.a & 0xff), 0));
    }

    public Color multiply(Color val) {
        return new Color((byte)(((int)this.r & 0xff) * ((int)val.r & 0xff) / 255),
                         (byte)(((int)this.g & 0xff) * ((int)val.g & 0xff) / 255),
                         (byte)(((int)this.b & 0xff) * ((int)val.b & 0xff) / 255),
                         (byte)(((int)this.a & 0xff) * ((int)val.a & 0xff) / 255));
    }

    public Color clone() {
        return new Color(this.r, this.g, this.b, this.a);
    }

    public String toString() {
        return "{r=" + ((int)r & 0xff) +
                ", g=" + ((int)g & 0xff) +
                ", b=" + ((int)b & 0xff) +
                ", a=" + ((int)a & 0xff) + "}";
    }
}
