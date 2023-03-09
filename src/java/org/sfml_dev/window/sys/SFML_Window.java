package org.sfml_dev.window.sys;

import org.sfml_dev.window.Window;

public class SFML_Window {
    static {
        SharedLib.load();
    }
    private SFML_Window() {}

    public static final long sf_ContextSettings_sizeof = sf_ContextSettings_sizeof();
    public static final long sf_Cursor_sizeof = sf_Cursor_sizeof();
    public static final long sf_Event_sizeof = sf_Event_sizeof();
    public static final long sf_Event_size = sf_Event_size();
    public static final long sf_Event_key = sf_Event_key();
    public static final long sf_Event_text = sf_Event_text();
    public static final long sf_Event_mouseMove = sf_Event_mouseMove();
    public static final long sf_Event_mouseButton = sf_Event_mouseButton();
    public static final long sf_Event_mouseWheel = sf_Event_mouseWheel();
    public static final long sf_Event_mouseWheelScroll = sf_Event_mouseWheelScroll();
    public static final long sf_Event_joystickMove = sf_Event_joystickMove();
    public static final long sf_Event_joystickButton = sf_Event_joystickButton();
    public static final long sf_Event_joystickConnect = sf_Event_joystickConnect();
    public static final long sf_Event_touch = sf_Event_touch();
    public static final long sf_Event_sensor = sf_Event_sensor();
    public static final long sf_GlResource_sizeof = sf_GlResource_sizeof();
    public static final long sf_GlResource_TransientContextLock_sizeof = sf_GlResource_TransientContextLock_sizeof();
    public static final long sf_Joystick_Identification_sizeof = sf_Joystick_Identification_sizeof();
    public static final long sf_Joystick_Identification_name = sf_Joystick_Identification_name();
    public static final long sf_VideoMode_sizeof = sf_VideoMode_sizeof();
    public static final long sf_Window_sizeof = sf_Window_sizeof();

    public static native void sf_Clipboard_getString(long ret);
    public static native void sf_Clipboard_setString(long text);
    private static native long sf_ContextSettings_sizeof();
    public static native void sf_ContextSettings_ContextSettings(long this_, int depth, int stencil, int antialiasing, int major, int minor, int attributes, boolean sRgb);
    public static native int sf_ContextSettings_getDepthBits(long this_);
    public static native int sf_ContextSettings_getStencilBits(long this_);
    public static native int sf_ContextSettings_getAntialiasingLevel(long this_);
    public static native int sf_ContextSettings_getMajorVersion(long this_);
    public static native int sf_ContextSettings_getMinorVersion(long this_);
    public static native int sf_ContextSettings_getAttributeFlags(long this_);
    public static native boolean sf_ContextSettings_getSRgbCapable(long this_);
    private static native long sf_Cursor_sizeof();
    public static native void sf_Cursor_Cursor(long this_);
    public static native void sf_Cursor_destructor(long this_);
    public static native boolean sf_Cursor_loadFromPixels(long this_, long pixels, long size, long hotspot);
    public static native boolean sf_Cursor_loadFromSystem(long this_, int type);
    private static native long sf_Event_sizeof();
    public static native void sf_Event_Event(long this_);
    public static native int sf_Event_getType(long this_);
    private static native long sf_Event_size();
    private static native long sf_Event_key();
    private static native long sf_Event_text();
    private static native long sf_Event_mouseMove();
    private static native long sf_Event_mouseButton();
    private static native long sf_Event_mouseWheel();
    private static native long sf_Event_mouseWheelScroll();
    private static native long sf_Event_joystickMove();
    private static native long sf_Event_joystickButton();
    private static native long sf_Event_joystickConnect();
    private static native long sf_Event_touch();
    private static native long sf_Event_sensor();
    public static native int sf_Event_SizeEvent_getWidth(long this_);
    public static native int sf_Event_SizeEvent_getHeight(long this_);
    public static native int sf_Event_KeyEvent_getCode(long this_);
    public static native boolean sf_Event_KeyEvent_getAlt(long this_);
    public static native boolean sf_Event_KeyEvent_getControl(long this_);
    public static native boolean sf_Event_KeyEvent_getShift(long this_);
    public static native boolean sf_Event_KeyEvent_getSystem(long this_);
    public static native int sf_Event_TextEvent_getUnicode(long this_);
    public static native int sf_Event_MouseMoveEvent_getX(long this_);
    public static native int sf_Event_MouseMoveEvent_getY(long this_);
    public static native int sf_Event_MouseButtonEvent_getButton(long this_);
    public static native int sf_Event_MouseButtonEvent_getX(long this_);
    public static native int sf_Event_MouseButtonEvent_getY(long this_);
    public static native int sf_Event_MouseWheelEvent_getDelta(long this_);
    public static native int sf_Event_MouseWheelEvent_getX(long this_);
    public static native int sf_Event_MouseWheelEvent_getY(long this_);
    public static native int sf_Event_MouseWheelScrollEvent_getWheel(long this_);
    public static native float sf_Event_MouseWheelScrollEvent_getDelta(long this_);
    public static native int sf_Event_MouseWheelScrollEvent_getX(long this_);
    public static native int sf_Event_MouseWheelScrollEvent_getY(long this_);
    public static native int sf_Event_JoystickConnectEvent_getJoystickId(long this_);
    public static native int sf_Event_JoystickMoveEvent_getJoystickId(long this_);
    public static native int sf_Event_JoystickMoveEvent_getAxis(long this_);
    public static native float sf_Event_JoystickMoveEvent_getPosition(long this_);
    public static native int sf_Event_JoystickButtonEvent_getJoystickId(long this_);
    public static native int sf_Event_JoystickButtonEvent_getButton(long this_);
    public static native int sf_Event_TouchEvent_getFinger(long this_);
    public static native int sf_Event_TouchEvent_getX(long this_);
    public static native int sf_Event_TouchEvent_getY(long this_);
    public static native int sf_Event_SensorEvent_getType(long this_);
    public static native float sf_Event_SensorEvent_getX(long this_);
    public static native float sf_Event_SensorEvent_getY(long this_);
    public static native float sf_Event_SensorEvent_getZ(long this_);
    private static native long sf_GlResource_sizeof();
    public static native void sf_GlResource_GlResource(long this_);
    public static native void sf_GlResource_destructor(long this_);
    public static native void sf_GlResource_registerContextDestroyCallback(long callback, long arg);
    private static native long sf_GlResource_TransientContextLock_sizeof();
    public static native void sf_GlResource_TransientContextLock_TransientContextLock(long this_);
    public static native void sf_GlResource_TransientContextLock_destructor(long this_);
    public static native boolean sf_Joystick_isConnected(int joystick);
    public static native int sf_Joystick_getButtonCount(int joystick);
    public static native boolean sf_Joystick_hasAxis(int joystick, int axis);
    public static native boolean sf_Joystick_isButtonPressed(int joystick, int button);
    public static native float sf_Joystick_getAxisPosition(int joystick, int axis);
    public static native void sf_Joystick_getIdentification(long ret, int joystick);
    public static native void sf_Joystick_update();
    private static native long sf_Joystick_Identification_sizeof();
    public static native void sf_Joystick_Identification_destructor(long this_);
    private static native long sf_Joystick_Identification_name();
    public static native int sf_Joystick_Identification_getVendorId(long this_);
    public static native int sf_Joystick_Identification_getProductId(long this_);
    public static native boolean sf_Keyboard_isKeyPressed(int key);
    public static native void sf_Keyboard_setVirtualKeyboardVisible(boolean visible);
    public static native boolean sf_Mouse_isButtonPressed(int button);
    public static native long sf_Mouse_getPosition();
    public static native long sf_Mouse_getPosition(long relativeTo);
    public static native void sf_Mouse_setPosition(long position);
    public static native void sf_Mouse_setPosition(long position, long relativeTo);
    public static native boolean sf_Sensor_isAvailable(int sensor);
    public static native void sf_Sensor_setEnabled(int sensor, boolean enabled);
    public static native void sf_Sensor_getValue(long ret, int sensor);
    public static native boolean sf_Touch_isDown(int finger);
    public static native long sf_Touch_getPosition(int finger);
    public static native int sf_Touch_getPosition(int finger, long relativeTo);
    private static native long sf_VideoMode_sizeof();
    public static native void sf_VideoMode_VideoMode(long this_, int modeWidth, int modeHeight, int modeBitsPerPixel);
    public static native void sf_VideoMode_getDesktopMode(long ret);
    public static native long sf_VideoMode_getFullscreenModes();
    public static native int sf_VideoMode_getWidth(long this_);
    public static native int sf_VideoMode_getHeight(long this_);
    public static native int sf_VideoMode_getBitsPerPixel(long this_);
    private static native long sf_Window_sizeof();
    public static native void sf_Window_Window(long this_, Window obj);
    public static native void sf_Window_Window(long this_, Window obj, long mode, int mode1, long title, int style, long settings);
    public static native void sf_Window_Window(long this_, Window obj, long handle, long settings);
    public static native void sf_Window_destructor(long this_);
    public static native void sf_Window_create(long this_, long mode, int mode1, long title, int style, long settings);
    public static native void sf_Window_create(long this_, long handle, long settings);
    public static native void sf_Window_close(long this_);
    public static native boolean sf_Window_isOpen(long this_);
    public static native long sf_Window_getSettings(long this_);
    public static native boolean sf_Window_pollEvent(long this_, long event);
    public static native boolean sf_Window_waitEvent(long this_, long event);
    public static native long sf_Window_getPosition(long this_);
    public static native void sf_Window_setPosition(long this_, long position);
    public static native long sf_Window_getSize(long this_);
    public static native void sf_Window_setSize(long this_, long size);
    public static native void sf_Window_setTitle(long this_, long title);
    public static native void sf_Window_setIcon(long this_, int width, int height, long pixels);
    public static native void sf_Window_setVisible(long this_, boolean visible);
    public static native void sf_Window_setVerticalSyncEnabled(long this_, boolean enabled);
    public static native void sf_Window_setMouseCursorVisible(long this_, boolean visible);
    public static native void sf_Window_setMouseCursorGrabbed(long this_, boolean grabbed);
    public static native void sf_Window_setMouseCursor(long this_, long cursor);
    public static native void sf_Window_setKeyRepeatEnabled(long this_, boolean enabled);
    public static native void sf_Window_setFramerateLimit(long this_, int limit);
    public static native void sf_Window_setJoystickThreshold(long this_, float threshold);
    public static native boolean sf_Window_setActive(long this_, boolean active);
    public static native void sf_Window_requestFocus(long this_);
    public static native boolean sf_Window_hasFocus(long this_);
    public static native void sf_Window_display(long this_);
    public static native long sf_Window_getSystemHandle(long this_);
}
