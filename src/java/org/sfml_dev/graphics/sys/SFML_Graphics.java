package org.sfml_dev.graphics.sys;

public class SFML_Graphics {
    static {
        SharedLib.load();
    }
    private SFML_Graphics() {}

    public static final long sf_FloatRect_sizeof = sf_FloatRect_sizeof();
    public static final long sf_Transform_sizeof = sf_Transform_sizeof();

    private static native long sf_FloatRect_sizeof();
    public static native void sf_FloatRect_FloatRect(long this_, float rectLeft, float rectTop, float rectWidth, float rectHeight);
    public static native float sf_FloatRect_getLeft(long this_);
    public static native float sf_FloatRect_getTop(long this_);
    public static native float sf_FloatRect_getWidth(long this_);
    public static native float sf_FloatRect_getHeight(long this_);
    private static native long sf_Transform_sizeof();
    public static native void sf_Transform_Transform(long this_);
    public static native void sf_Transform_Transform(long this_, float a00, float a01, float a02, float a10, float a11, float a12, float a20, float a21, float a22);
    public static native long sf_Transform_getMatrix(long this_);
    public static native void sf_Transform_getInverse(long ret, long this_);
    public static native long sf_Transform_transformPoint(long this_, float x, float y);
    public static native long sf_Transform_transformPoint(long this_, long point);
    public static native void sf_Transform_transformRect(long ret, long this_, long rectangle);
    public static native long sf_Transform_combine(long this_, long transform);
    public static native long sf_Transform_translate(long this_, float x, float y);
    public static native long sf_Transform_translate(long this_, long offset);
    public static native long sf_Transform_rotate(long this_, float angle);
    public static native long sf_Transform_rotate(long this_, float angle, float centerX, float centerY);
    public static native long sf_Transform_rotate(long this_, float angle, long center);
    public static native long sf_Transform_scale(long this_, float scaleX, float scaleY);
    public static native long sf_Transform_scale(long this_, float scaleX, float scaleY, float centerX, float centerY);
    public static native long sf_Transform_scale(long this_, long factors);
    public static native long sf_Transform_scale(long this_, long factors, long center);
    public static native void operator_mul__sf_Transform__sf_Transform(long ret, long left, long right);
    public static native long operator_mul__sf_Transform__sf_Vector2f(long left, long right);
    public static native boolean operator_eq__sf_Transform__sf_Transform(long left, long right);
}