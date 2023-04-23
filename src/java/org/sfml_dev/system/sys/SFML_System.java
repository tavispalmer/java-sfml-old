package org.sfml_dev.system.sys;

public class SFML_System {
    static {
        SharedLib.load();
    }
    private SFML_System() {}

    public static final long sf_Clock_sizeof = sf_Clock_sizeof();
    public static final long sf_String_sizeof = sf_String_sizeof();
    public static final long sf_Time_sizeof = sf_Time_sizeof();
    public static final long sf_Time_Zero = sf_Time_Zero();
    public static final long sf_Vector2i_sizeof = sf_Vector2i_sizeof();
    public static final long sf_Vector2u_sizeof = sf_Vector2u_sizeof();
    public static final long sf_Vector2f_sizeof = sf_Vector2f_sizeof();
    public static final long sf_Vector3f_sizeof = sf_Vector3f_sizeof();

    private static native long sf_Clock_sizeof();
    public static native void sf_Clock_Clock(long this_);
    public static native void sf_Clock_Clock(long this_, long copy);
    public static native void sf_Clock_getElapsedTime(long ret, long this_);
    public static native void sf_Clock_restart(long ret, long this_);
    private static native long sf_String_sizeof();
    public static native void sf_String_String(long this_);
    public static native void sf_String_destructor(long this_);
    public static native void sf_String_fromUtf16(long ret, long begin, long end);
    public static native void sf_String_toUtf16(long ret, long this_);
    private static native long sf_Time_sizeof();
    private static native long sf_Time_Zero();
    public static native void sf_Time_Time(long this_);
    public static native void sf_Time_Time(long this_, long copy);
    public static native float sf_Time_asSeconds(long this_);
    public static native int sf_Time_asMilliseconds(long this_);
    public static native long sf_Time_asMicroseconds(long this_);
    public static native void sf_seconds(long ret, float amount);
    public static native void sf_milliseconds(long ret, int amount);
    public static native void sf_microseconds(long ret, long amount);
    public static native boolean operator_eq__sf_Time(long left, long right);
    public static native boolean operator_lt__sf_Time(long left, long right);
    public static native void operator_neg__sf_Time(long ret, long right);
    public static native void operator_add__sf_Time(long ret, long left, long right);
    public static native void operator_sub__sf_Time(long ret, long left, long right);
    public static native void operator_mul__sf_Time(long ret, long left, float right);
    public static native void operator_mul__sf_Time(long ret, long left, long right);
    public static native void operator_div__sf_Time(long ret, long left, float right);
    public static native void operator_div__sf_Time(long ret, long left, long right);
    public static native float operator_div__sf_Time(long left, long right);
    public static native void operator_rem__sf_Time(long ret, long left, long right);
    private static native long sf_Vector2i_sizeof();
    public static native void sf_Vector2i_Vector2i(long this_, int x, int y);
    public static native int sf_Vector2i_getX(long this_);
    public static native int sf_Vector2i_getY(long this_);
    private static native long sf_Vector2u_sizeof();
    public static native void sf_Vector2u_Vector2u(long this_, int x, int y);
    public static native int sf_Vector2u_getX(long this_);
    public static native int sf_Vector2u_getY(long this_);
    private static native long sf_Vector2f_sizeof();
    public static native void sf_Vector2f_Vector2f(long this_, float x, float y);
    public static native float sf_Vector2f_getX(long this_);
    public static native float sf_Vector2f_getY(long this_);
    private static native long sf_Vector3f_sizeof();
    public static native float sf_Vector3f_getX(long this_);
    public static native float sf_Vector3f_getY(long this_);
    public static native float sf_Vector3f_getZ(long this_);
}
