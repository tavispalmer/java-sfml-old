package org.sfml_dev.window.sys;

public class SFML_Window {
    static {
        SharedLib.load();
    }
    private SFML_Window() {}

    public static native void sf_Clipboard_getString(long ret);
    public static native void sf_Clipboard_setString(long text);
}
