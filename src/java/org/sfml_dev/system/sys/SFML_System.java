package org.sfml_dev.system.sys;

public class SFML_System {
    static {
        SharedLib.load();
    }
    private SFML_System() {}

    public static native long sf_Clock_sizeof();
    public static native void sf_Clock_Clock(long this_);
    public static native long sf_Clock_getElapsedTime(long this_);
    public static native long sf_Clock_restart(long this_);
    public static native long sf_String_sizeof();
    public static native void sf_String_String(long this_);
    public static native void sf_String_destructor(long this_);
    public static native void sf_String_fromUtf16(long ret, long begin, long end);
    public static native void sf_String_toUtf16(long ret, long this_);
}
