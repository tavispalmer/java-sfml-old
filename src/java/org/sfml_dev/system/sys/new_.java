package org.sfml_dev.system.sys;

public class new_ {
    private new_() {}
    static {
        SharedLib.load();
    }

    public static native long operator_new(long count);
    public static native void operator_delete(long ptr);
}
