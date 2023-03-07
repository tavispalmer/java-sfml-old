package org.sfml_dev.system.sys;

public class new_ {
    static {
        SharedLib.load();
    }
    private new_() {}

    public static native long operator_new(long count);
    public static native void operator_delete(long ptr);
}
