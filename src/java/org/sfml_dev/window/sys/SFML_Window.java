package org.sfml_dev.window.sys;

public class SFML_Window {
    static {
        SharedLib.load();
    }
    private SFML_Window() {}

    public static final long sf_GlResource_sizeof = sf_GlResource_sizeof();
    public static final long sf_GlResource_TransientContextLock_sizeof = sf_GlResource_TransientContextLock_sizeof();
    public static final long sf_VideoMode_sizeof = sf_VideoMode_sizeof();

    public static native void sf_Clipboard_getString(long ret);
    public static native void sf_Clipboard_setString(long text);
    private static native long sf_GlResource_sizeof();
    public static native void sf_GlResource_GlResource(long this_);
    public static native void sf_GlResource_destructor(long this_);
    public static native void sf_GlResource_registerContextDestroyCallback(long callback, long arg);
    private static native long sf_GlResource_TransientContextLock_sizeof();
    public static native void sf_GlResource_TransientContextLock_TransientContextLock(long this_);
    public static native void sf_GlResource_TransientContextLock_destructor(long this_);
    private static native long sf_VideoMode_sizeof();
    public static native void sf_VideoMode_VideoMode(long this_, int modeWidth, int modeHeight, int modeBitsPerPixel);
    public static native void sf_VideoMode_getDesktopMode(long ret);
    public static native long sf_VideoMode_getFullscreenModes();
    public static native int sf_VideoMode_getWidth(long this_);
    public static native int sf_VideoMode_getHeight(long this_);
    public static native int sf_VideoMode_getBitsPerPixel(long this_);
}
