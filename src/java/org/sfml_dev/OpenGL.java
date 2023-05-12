package org.sfml_dev;

public class OpenGL {
    private OpenGL() {}

    /*
     * Constants
     */

    /* Boolean values */
    public static final int GL_FALSE = 0;
    public static final int GL_TRUE = 1;

    /* Data types */
    public static final int GL_BYTE = 0x1400;
    public static final int GL_UNSIGNED_BYTE = 0x1401;
    public static final int GL_SHORT = 0x1402;
    public static final int GL_UNSIGNED_SHORT = 0x1403;
    public static final int GL_INT = 0x1404;
    public static final int GL_UNSIGNED_INT = 0x1405;
    public static final int GL_FLOAT = 0x1406;
    public static final int GL_2_BYTES = 0x1407;
    public static final int GL_3_BYTES = 0x1408;
    public static final int GL_4_BYTES = 0x1409;
    public static final int GL_DOUBLE = 0x140A;

    /* Primitives */
    public static final int GL_POINTS = 0x0000;
    public static final int GL_LINES = 0x0001;
    public static final int GL_LINE_LOOP = 0x0002;
    public static final int GL_LINE_STRIP = 0x0003;
    public static final int GL_TRIANGLES = 0x0004;
    public static final int GL_TRIANGLE_STRIP = 0x0005;
    public static final int GL_TRIANGLE_FAN = 0x0006;
    public static final int GL_QUADS = 0x0007;
    public static final int GL_QUAD_STRIP = 0x0008;
    public static final int GL_POLYGON = 0x0009;
}
