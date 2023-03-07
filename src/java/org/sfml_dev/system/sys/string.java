package org.sfml_dev.system.sys;

public class string {
    static {
        SharedLib.load();
    }
    private string() {}

    public static native long std_u16string_sizeof();
    public static native void std_u16string_destructor(long this_);
    public static native long std_u16string_data(long this_);
    public static native long std_u16string_size(long this_);
}
