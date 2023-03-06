package org.sfml_dev.system.sys;

public class System {
    private System() {}

    public static native void sf_Clock_Clock(long this_);
    public static native long sf_Clock_getElapsedTime(long this_);
    public static native long sf_Clock_restart(long this_);
}
