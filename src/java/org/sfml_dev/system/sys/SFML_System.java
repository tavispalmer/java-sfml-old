package org.sfml_dev.system.sys;

public class SFML_System {
    private SFML_System() {}
    static {
        SharedLib.load();
    }

    public static native long sf_Clock_sizeof();
    public static native void sf_Clock_Clock(long this_);
    public static native long sf_Clock_getElapsedTime(long this_);
    public static native long sf_Clock_restart(long this_);
}
