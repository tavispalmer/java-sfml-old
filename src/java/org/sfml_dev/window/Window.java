package org.sfml_dev.window;

import java.util.function.LongConsumer;

import org.sfml_dev.system.*;

import static org.sfml_dev.system.sys.jni.*;
import static org.sfml_dev.system.sys.new_.*;
import static org.sfml_dev.system.sys.SFML_System.*;
import static org.sfml_dev.window.sys.SFML_Window.*;

public class Window extends GlResource {

    public EventHandler<Event> closed = null;

    public EventHandler<SizeEvent> resized = null;

    public EventHandler<Event> lostFocus = null;

    public EventHandler<Event> gainedFocus = null;

    public EventHandler<TextEvent> textEntered = null;

    public EventHandler<KeyEvent> keyPressed = null;

    public EventHandler<KeyEvent> keyReleased = null;

    public EventHandler<MouseWheelEvent> mouseWheelMoved = null;

    public EventHandler<MouseWheelScrollEvent> mouseWheelScrolled = null;

    public EventHandler<MouseButtonEvent> mouseButtonPressed = null;

    public EventHandler<MouseButtonEvent> mouseButtonReleased = null;

    public EventHandler<MouseMoveEvent> mouseMoved = null;

    public EventHandler<Event> mouseEntered = null;

    public EventHandler<Event> mouseLeft = null;

    public EventHandler<JoystickButtonEvent> joystickButtonPressed = null;
    
    public EventHandler<JoystickButtonEvent> joystickButtonReleased = null;

    public EventHandler<JoystickMoveEvent> joystickMoved = null;

    public EventHandler<JoystickConnectEvent> joystickConnected = null;
    
    public EventHandler<JoystickConnectEvent> joystickDisconnected = null;

    public EventHandler<TouchEvent> touchBegan = null;

    public EventHandler<TouchEvent> touchMoved = null;

    public EventHandler<TouchEvent> touchEnded = null;

    public EventHandler<SensorEvent> sensorChanged = null;

    public Window() {
        JavaWindow_JavaWindow(getPtr(), this);
    }

    public Window(VideoMode mode, String title) {
        this(mode, title, Style.DEFAULT, new ContextSettings());
    }

    public Window(VideoMode mode, String title, int style) {
        this(mode, title, style, new ContextSettings());
    }

    public Window(VideoMode mode, String title, int style, ContextSettings settings) {
        long sfMode = operator_new(sf_VideoMode_sizeof);
        sf_VideoMode_VideoMode(
            sfMode,
            mode.width,
            mode.height,
            mode.bitsPerPixel
        );
        
        long sfTitle = operator_new(sf_String_sizeof);
        if (title != null) {
            long chars = GetStringChars(title, 0);
            sf_String_fromUtf16(sfTitle, chars, chars + title.length() * 2);
            ReleaseStringChars(title, chars);
        }
        else {
            sf_String_String(sfTitle);
        }

        long sfSettings = operator_new(sf_ContextSettings_sizeof);
        sf_ContextSettings_ContextSettings(
            sfSettings,
            settings.depthBits,
            settings.stencilBits,
            settings.antialiasingLevel,
            settings.majorVersion,
            settings.minorVersion,
            settings.attributeFlags,
            settings.sRgbCapable
        );
        
        JavaWindow_JavaWindow(
            getPtr(),
            sfMode,
            sfTitle,
            style,
            sfSettings,
            this
        );

        operator_delete(sfSettings);

        sf_String_destructor(sfTitle);
        operator_delete(sfTitle);

        operator_delete(sfMode);
    }

    public Window(WindowHandle handle) {
        this(handle, new ContextSettings());
    }

    public Window(WindowHandle handle, ContextSettings settings) {
        long sfSettings = operator_new(sf_ContextSettings_sizeof);
        sf_ContextSettings_ContextSettings(
            sfSettings,
            settings.depthBits,
            settings.stencilBits,
            settings.antialiasingLevel,
            settings.majorVersion,
            settings.minorVersion,
            settings.attributeFlags,
            settings.sRgbCapable
        );
        
        JavaWindow_JavaWindow(
            getPtr(),
            handle.getPtr(),
            sfSettings,
            this
        );

        operator_delete(sfSettings);
    }
    
    public void create(VideoMode mode, String title) {
        create(mode, title, Style.DEFAULT, new ContextSettings());
    }

    public void create(VideoMode mode, String title, int style) {
        create(mode, title, style, new ContextSettings());
    }

    public void create(VideoMode mode, String title, int style, ContextSettings settings) {
        long sfMode = operator_new(sf_VideoMode_sizeof);
        sf_VideoMode_VideoMode(
            sfMode,
            mode.width,
            mode.height,
            mode.bitsPerPixel
        );
        
        long sfTitle = operator_new(sf_String_sizeof);
        if (title != null) {
            long chars = GetStringChars(title, 0);
            sf_String_fromUtf16(sfTitle, chars, chars + title.length() * 2);
            ReleaseStringChars(title, chars);
        }
        else {
            sf_String_String(sfTitle);
        }

        long sfSettings = operator_new(sf_ContextSettings_sizeof);
        sf_ContextSettings_ContextSettings(
            sfSettings,
            settings.depthBits,
            settings.stencilBits,
            settings.antialiasingLevel,
            settings.majorVersion,
            settings.minorVersion,
            settings.attributeFlags,
            settings.sRgbCapable
        );
        
        sf_Window_create(
            getPtr(),
            sfMode,
            sfTitle,
            style,
            sfSettings
        );

        operator_delete(sfSettings);

        sf_String_destructor(sfTitle);
        operator_delete(sfTitle);

        operator_delete(sfMode);
    }

    public void create(WindowHandle handle) {
        create(handle, new ContextSettings());
    }

    public void create(WindowHandle handle, ContextSettings settings) {
        long sfSettings = operator_new(sf_ContextSettings_sizeof);
        sf_ContextSettings_ContextSettings(
            sfSettings,
            settings.depthBits,
            settings.stencilBits,
            settings.antialiasingLevel,
            settings.majorVersion,
            settings.minorVersion,
            settings.attributeFlags,
            settings.sRgbCapable
        );
        
        sf_Window_create(
            getPtr(),
            handle.getPtr(),
            sfSettings
        );

        operator_delete(sfSettings);
    }

    public void close() {
        sf_Window_close(getPtr());
    }

    public boolean isOpen() {
        return sf_Window_isOpen(getPtr());
    }

    public ContextSettings getSettings() {
        long sfContext = sf_Window_getSettings(getPtr());
        return new ContextSettings(
            sf_ContextSettings_getDepthBits(sfContext),
            sf_ContextSettings_getStencilBits(sfContext),
            sf_ContextSettings_getAntialiasingLevel(sfContext),
            sf_ContextSettings_getMajorVersion(sfContext),
            sf_ContextSettings_getMinorVersion(sfContext),
            sf_ContextSettings_getAttributeFlags(sfContext),
            sf_ContextSettings_getSRgbCapable(sfContext)
        );
    }

    public void waitAndDispatchEvents() {
        long e = operator_new(sf_Event_sizeof);
        sf_Event_Event(e);
        if (sf_Window_waitEvent(getPtr(), e)) {
            callEventHandler(e);
        }
        operator_delete(e);
    }

    public void dispatchEvents() {
        long e = operator_new(sf_Event_sizeof);
        sf_Event_Event(e);
        while (sf_Window_pollEvent(getPtr(), e)) {
            callEventHandler(e);
        }
        operator_delete(e);
    }

    public Vector2i getPosition() {
        long sfPosition = operator_new(sf_Vector2i_sizeof);
        sf_Window_getPosition(sfPosition, getPtr());

        Vector2i position = new Vector2i(
            sf_Vector2i_getX(sfPosition),
            sf_Vector2i_getY(sfPosition)
        );
        operator_delete(sfPosition);
        return position;
    }

    public void setPosition(Vector2i position) {
        long sfPosition = operator_new(sf_Vector2i_sizeof);
        sf_Vector2i_Vector2i(
            sfPosition,
            position.x,
            position.y
        );

        sf_Window_setPosition(getPtr(), sfPosition);

        operator_delete(sfPosition);
    }

    public Vector2i getSize() {
        long sfSize = operator_new(sf_Vector2u_sizeof);
        sf_Window_getSize(sfSize, getPtr());

        Vector2i size = new Vector2i(
            sf_Vector2u_getX(sfSize),
            sf_Vector2u_getY(sfSize)
        );
        operator_delete(sfSize);
        return size;
    }

    public void setSize(Vector2i size) {
        long sfSize = operator_new(sf_Vector2u_sizeof);
        sf_Vector2u_Vector2u(
            sfSize,
            size.x,
            size.y
        );

        sf_Window_setSize(getPtr(), sfSize);

        operator_delete(sfSize);
    }

    public void setTitle(String title) {
        long sfTitle = operator_new(sf_String_sizeof);
        if (title != null) {
            long chars = GetStringChars(title, 0);
            sf_String_fromUtf16(sfTitle, chars, chars + title.length() * 2);
            ReleaseStringChars(title, chars);
        }
        else {
            sf_String_String(sfTitle);
        }

        sf_Window_setTitle(getPtr(), sfTitle);

        sf_String_destructor(sfTitle);
        operator_delete(sfTitle);
    }

    public void setIcon(int width, int height, byte[] pixels) {
        if (pixels != null) {
            long elems = GetByteArrayElements(pixels, 0);
            
            sf_Window_setIcon(
                getPtr(),
                width,
                height,
                elems
            );

            ReleaseByteArrayElements(pixels, elems, JNI_ABORT);
        }
        else {
            sf_Window_setIcon(
                getPtr(),
                width,
                height,
                0
            );
        }
    }

    public void setVisible(boolean visible) {
        sf_Window_setVisible(getPtr(), visible);
    }

    public void setVerticalSyncEnabled(boolean enabled) {
        sf_Window_setVerticalSyncEnabled(getPtr(), enabled);
    }

    public void setMouseCursorVisible(boolean visible) {
        sf_Window_setMouseCursorVisible(getPtr(), visible);
    }

    public void setMouseCursorGrabbed(boolean grabbed) {
        sf_Window_setMouseCursorGrabbed(getPtr(), grabbed);
    }

    public void setMouseCursor(Cursor cursor) {
        sf_Window_setMouseCursor(getPtr(), cursor.getPtr());
    }

    public void setKeyRepeatEnabled(boolean enabled) {
        sf_Window_setKeyRepeatEnabled(getPtr(), enabled);
    }

    public void setFramerateLimit(int limit) {
        sf_Window_setFramerateLimit(getPtr(), limit);
    }

    public void setJoystickThreshold(float threshold) {
        sf_Window_setJoystickThreshold(getPtr(), threshold);
    }

    public boolean setActive() {
        return setActive(true);
    }

    public boolean setActive(boolean active) {
        return sf_Window_setActive(getPtr(), active);
    }

    public void requestFocus() {
        sf_Window_requestFocus(getPtr());
    }

    public boolean hasFocus() {
        return sf_Window_hasFocus(getPtr());
    }

    public void display() {
        sf_Window_display(getPtr());
    }

    public WindowHandle getSystemHandle() {
        return new WindowHandle(sf_Window_getSystemHandle(getPtr()));
    }

    protected void onCreate() {
        sf_Window_onCreate(getPtr());
    }

    protected void onResize() {
        sf_Window_onResize(getPtr());
    }

    protected long sizeof() {
        return JavaWindow_sizeof;
    }

    protected LongConsumer getDestructor() {
        return ptr -> sf_Window_destructor(ptr);
    }

    private static final int EVENT_CLOSED = 0;
    private static final int EVENT_RESIZED = 1;
    private static final int EVENT_LOST_FOCUS = 2;
    private static final int EVENT_GAINED_FOCUS = 3;
    private static final int EVENT_TEXT_ENTERED = 4;
    private static final int EVENT_KEY_PRESSED = 5;
    private static final int EVENT_KEY_RELEASED = 6;
    private static final int EVENT_MOUSE_WHEEL_MOVED = 7;
    private static final int EVENT_MOUSE_WHEEL_SCROLLED = 8;
    private static final int EVENT_MOUSE_BUTTON_PRESSED = 9;
    private static final int EVENT_MOUSE_BUTTON_RELEASED = 10;
    private static final int EVENT_MOUSE_MOVED = 11;
    private static final int EVENT_MOUSE_ENTERED = 12;
    private static final int EVENT_MOUSE_LEFT = 13;
    private static final int EVENT_JOYSTICK_BUTTON_PRESSED = 14;
    private static final int EVENT_JOYSTICK_BUTTON_RELEASED = 15;
    private static final int EVENT_JOYSTICK_MOVED = 16;
    private static final int EVENT_JOYSTICK_CONNECTED = 17;
    private static final int EVENT_JOYSTICK_DISCONNECTED = 18;
    private static final int EVENT_TOUCH_BEGAN = 19;
    private static final int EVENT_TOUCH_MOVED = 20;
    private static final int EVENT_TOUCH_ENDED = 21;
    private static final int EVENT_SENSOR_CHANGED = 22;

    private void callEventHandler(long e) {
        switch (sf_Event_getType(e)) {
            case EVENT_CLOSED -> {
                if (closed != null) {
                    closed.invoke(this, new Event());
                }
            }
            case EVENT_RESIZED -> {
                if (resized != null) {
                    long e_size = e + sf_Event_size;
                    resized.invoke(this, new SizeEvent(
                        sf_Event_SizeEvent_getWidth(e_size),
                        sf_Event_SizeEvent_getHeight(e_size)
                    ));
                }
            }
            case EVENT_LOST_FOCUS -> {
                if (lostFocus != null) {
                    lostFocus.invoke(this, new Event());
                }
            }
            case EVENT_GAINED_FOCUS -> {
                if (gainedFocus != null) {
                    gainedFocus.invoke(this, new Event());
                }
            }
            case EVENT_TEXT_ENTERED -> {
                if (textEntered != null) {
                    long e_text = e + sf_Event_text;
                    textEntered.invoke(this, new TextEvent(
                        sf_Event_TextEvent_getUnicode(e_text)
                    ));
                }
            }
            case EVENT_KEY_PRESSED -> {
                if (keyPressed != null) {
                    long e_key = e + sf_Event_key;
                    int e_key_code = sf_Event_KeyEvent_getCode(e_key);
                    keyPressed.invoke(this, new KeyEvent(
                        e_key_code != -1 ? Keyboard.Key.values()[e_key_code] : Keyboard.Key.UNKNOWN,
                        sf_Event_KeyEvent_getAlt(e_key),
                        sf_Event_KeyEvent_getControl(e_key),
                        sf_Event_KeyEvent_getShift(e_key),
                        sf_Event_KeyEvent_getSystem(e_key)
                    ));
                }
            }
            case EVENT_KEY_RELEASED -> {
                if (keyReleased != null) {
                    long e_key = e + sf_Event_key;
                    int e_key_code = sf_Event_KeyEvent_getCode(e_key);
                    keyReleased.invoke(this, new KeyEvent(
                        e_key_code != -1 ? Keyboard.Key.values()[e_key_code] : Keyboard.Key.UNKNOWN,
                        sf_Event_KeyEvent_getAlt(e_key),
                        sf_Event_KeyEvent_getControl(e_key),
                        sf_Event_KeyEvent_getShift(e_key),
                        sf_Event_KeyEvent_getSystem(e_key)
                    ));
                }
            }
            case EVENT_MOUSE_WHEEL_MOVED -> {
                if (mouseWheelMoved != null) {
                    long e_mouseWheel = e + sf_Event_mouseWheel;
                    mouseWheelMoved.invoke(this, new MouseWheelEvent(
                        sf_Event_MouseWheelEvent_getDelta(e_mouseWheel),
                        sf_Event_MouseWheelEvent_getX(e_mouseWheel),
                        sf_Event_MouseWheelEvent_getY(e_mouseWheel)
                    ));
                }
            }
            case EVENT_MOUSE_WHEEL_SCROLLED -> {
                if (mouseWheelScrolled != null) {
                    long e_mouseWheelScroll = e + sf_Event_mouseWheelScroll;
                    mouseWheelScrolled.invoke(this, new MouseWheelScrollEvent(
                        Mouse.Wheel.values()[sf_Event_MouseWheelScrollEvent_getWheel(e_mouseWheelScroll)],
                        sf_Event_MouseWheelScrollEvent_getDelta(e_mouseWheelScroll),
                        sf_Event_MouseWheelScrollEvent_getX(e_mouseWheelScroll),
                        sf_Event_MouseWheelScrollEvent_getY(e_mouseWheelScroll)
                    ));
                }
            }
            case EVENT_MOUSE_BUTTON_PRESSED -> {
                if (mouseButtonPressed != null) {
                    long e_mouseButton = e + sf_Event_mouseButton;
                    mouseButtonPressed.invoke(this, new MouseButtonEvent(
                        Mouse.Button.values()[sf_Event_MouseButtonEvent_getButton(e_mouseButton)],
                        sf_Event_MouseButtonEvent_getX(e_mouseButton),
                        sf_Event_MouseButtonEvent_getY(e_mouseButton)
                    ));
                }
            }
            case EVENT_MOUSE_BUTTON_RELEASED -> {
                if (mouseButtonReleased != null) {
                    long e_mouseButton = e + sf_Event_mouseButton;
                    mouseButtonReleased.invoke(this, new MouseButtonEvent(
                        Mouse.Button.values()[sf_Event_MouseButtonEvent_getButton(e_mouseButton)],
                        sf_Event_MouseButtonEvent_getX(e_mouseButton),
                        sf_Event_MouseButtonEvent_getY(e_mouseButton)
                    ));
                }
            }
            case EVENT_MOUSE_MOVED -> {
                if (mouseMoved != null) {
                    long e_mouseMove = e + sf_Event_mouseMove;
                    mouseMoved.invoke(this, new MouseMoveEvent(
                        sf_Event_MouseMoveEvent_getX(e_mouseMove),
                        sf_Event_MouseMoveEvent_getY(e_mouseMove)
                    ));
                }
            }
            case EVENT_MOUSE_ENTERED -> {
                if (mouseEntered != null) {
                    mouseEntered.invoke(this, new Event());
                }
            }
            case EVENT_MOUSE_LEFT -> {
                if (mouseLeft != null) {
                    mouseLeft.invoke(this, new Event());
                }
            }
            case EVENT_JOYSTICK_BUTTON_PRESSED -> {
                if (joystickButtonPressed != null) {
                    long e_joystickButton = e + sf_Event_joystickButton;
                    joystickButtonPressed.invoke(this, new JoystickButtonEvent(
                        sf_Event_JoystickButtonEvent_getJoystickId(e_joystickButton),
                        sf_Event_JoystickButtonEvent_getButton(e_joystickButton)
                    ));
                }
            }
            case EVENT_JOYSTICK_BUTTON_RELEASED -> {
                if (joystickButtonReleased != null) {
                    long e_joystickButton = e + sf_Event_joystickButton;
                    joystickButtonReleased.invoke(this, new JoystickButtonEvent(
                        sf_Event_JoystickButtonEvent_getJoystickId(e_joystickButton),
                        sf_Event_JoystickButtonEvent_getButton(e_joystickButton)
                    ));
                }
            }
            case EVENT_JOYSTICK_MOVED -> {
                if (joystickMoved != null) {
                    long e_joystickMove = e + sf_Event_joystickMove;
                    joystickMoved.invoke(this, new JoystickMoveEvent(
                        sf_Event_JoystickMoveEvent_getJoystickId(e_joystickMove),
                        Joystick.Axis.values()[sf_Event_JoystickMoveEvent_getAxis(e_joystickMove)],
                        sf_Event_JoystickMoveEvent_getPosition(e_joystickMove)
                    ));
                }
            }
            case EVENT_JOYSTICK_CONNECTED -> {
                if (joystickConnected != null) {
                    long e_joystickConnect = e + sf_Event_joystickConnect;
                    joystickConnected.invoke(this, new JoystickConnectEvent(
                        sf_Event_JoystickConnectEvent_getJoystickId(e_joystickConnect)
                    ));
                }
            }
            case EVENT_JOYSTICK_DISCONNECTED -> {
                if (joystickDisconnected != null) {
                    long e_joystickConnect = e + sf_Event_joystickConnect;
                    joystickDisconnected.invoke(this, new JoystickConnectEvent(
                        sf_Event_JoystickConnectEvent_getJoystickId(e_joystickConnect)
                    ));
                }
            }
            case EVENT_TOUCH_BEGAN -> {
                if (touchBegan != null) {
                    long e_touch = e + sf_Event_touch;
                    touchBegan.invoke(this, new TouchEvent(
                        sf_Event_TouchEvent_getFinger(e_touch),
                        sf_Event_TouchEvent_getX(e_touch),
                        sf_Event_TouchEvent_getY(e_touch)
                    ));
                }
            }
            case EVENT_TOUCH_MOVED -> {
                if (touchMoved != null) {
                    long e_touch = e + sf_Event_touch;
                    touchMoved.invoke(this, new TouchEvent(
                        sf_Event_TouchEvent_getFinger(e_touch),
                        sf_Event_TouchEvent_getX(e_touch),
                        sf_Event_TouchEvent_getY(e_touch)
                    ));
                }
            }
            case EVENT_TOUCH_ENDED -> {
                if (touchEnded != null) {
                    long e_touch = e + sf_Event_touch;
                    touchEnded.invoke(this, new TouchEvent(
                        sf_Event_TouchEvent_getFinger(e_touch),
                        sf_Event_TouchEvent_getX(e_touch),
                        sf_Event_TouchEvent_getY(e_touch)
                    ));
                }
            }
            case EVENT_SENSOR_CHANGED -> {
                if (sensorChanged != null) {
                    long e_sensor = e + sf_Event_sensor;
                    sensorChanged.invoke(this, new SensorEvent(
                        Sensor.Type.values()[sf_Event_SensorEvent_getType(e_sensor)],
                        sf_Event_SensorEvent_getX(e_sensor),
                        sf_Event_SensorEvent_getY(e_sensor),
                        sf_Event_SensorEvent_getZ(e_sensor)
                    ));
                }
            }
        }
    }
}
