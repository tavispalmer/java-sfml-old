package org.sfml_dev.system.sys;

public class vector {
    static {
        SharedLib.load();
    }
    private vector() {}

    public static native long std_vector_sf_VideoMode_begin(long this_);
    public static native long std_vector_sf_VideoMode_end(long this_);
}
