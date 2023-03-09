#include "SFML_Window.h"
#include <SFML/Window.hpp>

class JavaGlResource : public sf::GlResource {
public:
    inline JavaGlResource() : GlResource() {}
    inline ~JavaGlResource() {}
    inline static void registerContextDestroyCallback(sf::ContextDestroyCallback callback, void *arg) {
        sf::GlResource::registerContextDestroyCallback(callback, arg);
    }
    class JavaTransientContextLock : public sf::GlResource::TransientContextLock {
    public:
        inline JavaTransientContextLock() : TransientContextLock() {}
        inline ~JavaTransientContextLock() {}
    };
};

class JavaWindow : public sf::Window {
public:
    static JNIEnv *env;

    JavaWindow(jobject obj) : Window(), obj(obj) {}
    JavaWindow(jobject obj, sf::VideoMode mode, const sf::String &title, sf::Uint32 style, const sf::ContextSettings &settings) : Window(mode, title, style, settings), obj(obj) {}
    JavaWindow(jobject obj, sf::WindowHandle handle, const sf::ContextSettings &settings) : Window(handle, settings), obj(obj) {}

protected:
    virtual void onCreate() {
        if (!windowClass) {
            windowClass = (jclass)env->NewGlobalRef(env->FindClass("org/sfml_dev/window/Window"));
        }
        if (!windowOnCreate) {
            windowOnCreate = env->GetMethodID(windowClass, "onCreate", "()V");
        }
        
        env->CallVoidMethod(obj, windowOnCreate);
    }

    virtual void onResize() {
        if (!windowClass) {
            windowClass = (jclass)env->NewGlobalRef(env->FindClass("org/sfml_dev/window/Window"));
        }
        if (!windowOnResize) {
            windowOnResize = env->GetMethodID(windowClass, "onResize", "()V");
        }

        env->CallVoidMethod(obj, windowOnResize);
    }

private:
    static jclass windowClass;
    static jmethodID windowOnCreate;
    static jmethodID windowOnResize;
    jobject obj;
};

JNIEnv *JavaWindow::env = NULL;
jclass JavaWindow::windowClass = NULL;
jmethodID JavaWindow::windowOnCreate = NULL;
jmethodID JavaWindow::windowOnResize = NULL;

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Clipboard_1getString(JNIEnv *, jclass, jlong ret)
{
    new (reinterpret_cast<void *>(ret)) sf::String(sf::Clipboard::getString());
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Clipboard_1setString(JNIEnv *, jclass, jlong text)
{
    sf::Clipboard::setString(*reinterpret_cast<sf::String *>(text));
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1ContextSettings_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::ContextSettings));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1ContextSettings_1ContextSettings(JNIEnv *, jclass, jlong this_, jint depth, jint stencil, jint antialiasing, jint major, jint minor, jint attributes, jboolean sRgb)
{
    new (reinterpret_cast<void *>(this_)) sf::ContextSettings(
        static_cast<unsigned int>(depth),
        static_cast<unsigned int>(stencil),
        static_cast<unsigned int>(antialiasing),
        static_cast<unsigned int>(major),
        static_cast<unsigned int>(minor),
        static_cast<unsigned int>(attributes),
        static_cast<bool>(sRgb)
    );
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1ContextSettings_1getDepthBits(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::ContextSettings *>(this_)->depthBits);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1ContextSettings_1getStencilBits(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::ContextSettings *>(this_)->stencilBits);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1ContextSettings_1getAntialiasingLevel(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::ContextSettings *>(this_)->antialiasingLevel);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1ContextSettings_1getMajorVersion(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::ContextSettings *>(this_)->majorVersion);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1ContextSettings_1getMinorVersion(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::ContextSettings *>(this_)->minorVersion);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1ContextSettings_1getAttributeFlags(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::ContextSettings *>(this_)->attributeFlags);
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1ContextSettings_1getSRgbCapable(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jboolean>(reinterpret_cast<sf::ContextSettings *>(this_)->sRgbCapable);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Cursor_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::Cursor));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Cursor_1Cursor(JNIEnv *, jclass, jlong this_)
{
    new (reinterpret_cast<void *>(this_)) sf::Cursor;
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Cursor_1destructor(JNIEnv *, jclass, jlong this_)
{
    reinterpret_cast<sf::Cursor *>(this_)->~Cursor();
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Cursor_1loadFromPixels(JNIEnv *, jclass, jlong this_, jlong pixels, jlong size, jlong hotspot)
{
    uint8_t cppSize[sizeof(sf::Vector2u)];
    reinterpret_cast<sf::Vector2u *>(cppSize)->x = (uint32_t)size;
    reinterpret_cast<sf::Vector2u *>(cppSize)->y = (uint32_t)(size >> 32);

    uint8_t cppHotspot[sizeof(sf::Vector2u)];
    reinterpret_cast<sf::Vector2u *>(cppHotspot)->x = (uint32_t)hotspot;
    reinterpret_cast<sf::Vector2u *>(cppHotspot)->y = (uint32_t)(hotspot >> 32);

    return static_cast<jboolean>(reinterpret_cast<sf::Cursor *>(this_)->loadFromPixels(
        reinterpret_cast<const sf::Uint8 *>(pixels),
        *reinterpret_cast<sf::Vector2u *>(cppSize),
        *reinterpret_cast<sf::Vector2u *>(cppHotspot)
    ));
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Cursor_1loadFromSystem(JNIEnv *, jclass, jlong this_, jint type)
{
    return static_cast<jboolean>(reinterpret_cast<sf::Cursor *>(this_)->loadFromSystem(
        static_cast<sf::Cursor::Type>(type)
    ));
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::Event));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1Event(JNIEnv *, jclass, jlong this_)
{
    new (reinterpret_cast<void *>(this_)) sf::Event;
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1getType(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event *>(this_)->type);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1size(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Event *>(NULL)->size);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1key(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Event *>(NULL)->key);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1text(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Event *>(NULL)->text);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1mouseMove(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Event *>(NULL)->mouseMove);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1mouseButton(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Event *>(NULL)->mouseButton);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1mouseWheel(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Event *>(NULL)->mouseWheel);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1mouseWheelScroll(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Event *>(NULL)->mouseWheelScroll);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1joystickMove(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Event *>(NULL)->joystickMove);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1joystickButton(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Event *>(NULL)->joystickButton);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1joystickConnect(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Event *>(NULL)->joystickConnect);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1touch(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Event *>(NULL)->touch);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1sensor(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Event *>(NULL)->sensor);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1SizeEvent_1getWidth(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::SizeEvent *>(this_)->width);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1SizeEvent_1getHeight(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::SizeEvent *>(this_)->height);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1KeyEvent_1getCode(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::KeyEvent *>(this_)->code);
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1KeyEvent_1getAlt(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jboolean>(reinterpret_cast<sf::Event::KeyEvent *>(this_)->alt);
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1KeyEvent_1getControl(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jboolean>(reinterpret_cast<sf::Event::KeyEvent *>(this_)->control);
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1KeyEvent_1getShift(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jboolean>(reinterpret_cast<sf::Event::KeyEvent *>(this_)->shift);
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1KeyEvent_1getSystem(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jboolean>(reinterpret_cast<sf::Event::KeyEvent *>(this_)->system);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1TextEvent_1getUnicode(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::TextEvent *>(this_)->unicode);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1MouseMoveEvent_1getX(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::MouseMoveEvent *>(this_)->x);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1MouseMoveEvent_1getY(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::MouseMoveEvent *>(this_)->y);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1MouseButtonEvent_1getButton(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::MouseButtonEvent *>(this_)->button);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1MouseButtonEvent_1getX(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::MouseButtonEvent *>(this_)->x);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1MouseButtonEvent_1getY(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::MouseButtonEvent *>(this_)->y);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1MouseWheelEvent_1getDelta(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::MouseWheelEvent *>(this_)->delta);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1MouseWheelEvent_1getX(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::MouseWheelEvent *>(this_)->x);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1MouseWheelEvent_1getY(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::MouseWheelEvent *>(this_)->y);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1MouseWheelScrollEvent_1getWheel(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::MouseWheelScrollEvent *>(this_)->wheel);
}

jfloat Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1MouseWheelScrollEvent_1getDelta(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::Event::MouseWheelScrollEvent *>(this_)->delta);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1MouseWheelScrollEvent_1getX(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::MouseWheelScrollEvent *>(this_)->x);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1MouseWheelScrollEvent_1getY(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::MouseWheelScrollEvent *>(this_)->y);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1JoystickConnectEvent_1getJoystickId(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::JoystickConnectEvent *>(this_)->joystickId);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1JoystickMoveEvent_1getJoystickId(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::JoystickMoveEvent *>(this_)->joystickId);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1JoystickMoveEvent_1getAxis(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::JoystickMoveEvent *>(this_)->axis);
}

jfloat Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1JoystickMoveEvent_1getPosition(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::Event::JoystickMoveEvent *>(this_)->position);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1JoystickButtonEvent_1getJoystickId(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::JoystickButtonEvent *>(this_)->joystickId);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1JoystickButtonEvent_1getButton(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::JoystickButtonEvent *>(this_)->button);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1TouchEvent_1getFinger(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::TouchEvent *>(this_)->finger);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1TouchEvent_1getX(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::TouchEvent *>(this_)->x);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1TouchEvent_1getY(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::TouchEvent *>(this_)->y);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1SensorEvent_1getType(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Event::SensorEvent *>(this_)->type);
}

jfloat Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1SensorEvent_1getX(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::Event::SensorEvent *>(this_)->x);
}

jfloat Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1SensorEvent_1getY(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::Event::SensorEvent *>(this_)->y);
}

jfloat Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Event_1SensorEvent_1getZ(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::Event::SensorEvent *>(this_)->z);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1GlResource_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(JavaGlResource));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1GlResource_1GlResource(JNIEnv *, jclass, jlong this_)
{
    new (reinterpret_cast<void *>(this_)) JavaGlResource;
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1GlResource_1destructor(JNIEnv *, jclass, jlong this_)
{
    reinterpret_cast<JavaGlResource *>(this_)->~JavaGlResource();
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1GlResource_1registerContextDestroyCallback(JNIEnv *, jclass, jlong callback, jlong arg)
{
    JavaGlResource::registerContextDestroyCallback(reinterpret_cast<sf::ContextDestroyCallback>(callback), reinterpret_cast<void *>(arg));
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1GlResource_1TransientContextLock_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(JavaGlResource::JavaTransientContextLock));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1GlResource_1TransientContextLock_1TransientContextLock(JNIEnv *, jclass, jlong this_)
{
    new (reinterpret_cast<void *>(this_)) JavaGlResource::JavaTransientContextLock;
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1GlResource_1TransientContextLock_1destructor(JNIEnv *, jclass, jlong this_)
{
    reinterpret_cast<JavaGlResource::JavaTransientContextLock *>(this_)->~JavaTransientContextLock();
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Joystick_1isConnected(JNIEnv *, jclass, jint joystick)
{
    return static_cast<jboolean>(sf::Joystick::isConnected(
        static_cast<unsigned int>(joystick)
    ));
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Joystick_1getButtonCount(JNIEnv *, jclass, jint joystick)
{
    return static_cast<jint>(sf::Joystick::getButtonCount(
        static_cast<unsigned int>(joystick)
    ));
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Joystick_1hasAxis(JNIEnv *, jclass, jint joystick, jint axis)
{
    return static_cast<jboolean>(sf::Joystick::hasAxis(
        static_cast<unsigned int>(joystick),
        static_cast<sf::Joystick::Axis>(axis)
    ));
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Joystick_1isButtonPressed(JNIEnv *, jclass, jint joystick, jint button)
{
    return static_cast<jboolean>(sf::Joystick::isButtonPressed(
        static_cast<unsigned int>(joystick),
        static_cast<unsigned int>(button)
    ));
}

jfloat Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Joystick_1getAxisPosition(JNIEnv *, jclass, jint joystick, jint axis)
{
    return static_cast<jfloat>(sf::Joystick::getAxisPosition(
        static_cast<unsigned int>(joystick),
        static_cast<sf::Joystick::Axis>(axis)
    ));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Joystick_1getIdentification(JNIEnv *, jclass, jlong ret, jint joystick)
{
    new (reinterpret_cast<void *>(ret)) sf::Joystick::Identification(sf::Joystick::getIdentification(
        static_cast<unsigned int>(joystick)
    ));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Joystick_1update(JNIEnv *, jclass)
{
    sf::Joystick::update();
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Joystick_1Identification_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::Joystick::Identification));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Joystick_1Identification_1destructor(JNIEnv *, jclass, jlong this_)
{
    reinterpret_cast<sf::Joystick::Identification *>(this_)->~Identification();
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Joystick_1Identification_1name(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Joystick::Identification *>(NULL)->name);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Joystick_1Identification_1getVendorId(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Joystick::Identification *>(this_)->vendorId);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Joystick_1Identification_1getProductId(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Joystick::Identification *>(this_)->productId);
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Keyboard_1isKeyPressed(JNIEnv *, jclass, jint key)
{
    return static_cast<jboolean>(sf::Keyboard::isKeyPressed(
        static_cast<sf::Keyboard::Key>(key)
    ));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Keyboard_1setVirtualKeyboardVisible(JNIEnv *, jclass, jboolean visible)
{
    sf::Keyboard::setVirtualKeyboardVisible(
        static_cast<bool>(visible)
    );
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Mouse_1isButtonPressed(JNIEnv *, jclass, jint button)
{
    return static_cast<jboolean>(sf::Mouse::isButtonPressed(
        static_cast<sf::Mouse::Button>(button)
    ));
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Mouse_1getPosition__(JNIEnv *, jclass)
{
    sf::Vector2i position = sf::Mouse::getPosition();
    return static_cast<jlong>(
        ((uint64_t)position.x & 0xffffffff) |
        ((uint64_t)position.y << 32)
    );
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Mouse_1getPosition__J(JNIEnv *, jclass, jlong relativeTo)
{
    sf::Vector2i position = sf::Mouse::getPosition(
        *reinterpret_cast<sf::Window *>(relativeTo)
    );
    return static_cast<jlong>(
        ((uint64_t)position.x & 0xffffffff) |
        ((uint64_t)position.y << 32)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Mouse_1setPosition__J(JNIEnv *, jclass, jlong position)
{
    sf::Mouse::setPosition(
        *reinterpret_cast<sf::Vector2i *>(position)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Mouse_1setPosition__JJ(JNIEnv *, jclass, jlong position, jlong relativeTo)
{
    sf::Mouse::setPosition(
        *reinterpret_cast<sf::Vector2i *>(position),
        *reinterpret_cast<sf::Window *>(relativeTo)
    );
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Sensor_1isAvailable(JNIEnv *, jclass, jint sensor)
{
    return static_cast<jboolean>(sf::Sensor::isAvailable(
        static_cast<sf::Sensor::Type>(sensor)
    ));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Sensor_1setEnabled(JNIEnv *, jclass, jint sensor, jboolean enabled)
{
    sf::Sensor::setEnabled(
        static_cast<sf::Sensor::Type>(sensor),
        static_cast<bool>(enabled)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Sensor_1getValue(JNIEnv *, jclass, jlong ret, jint sensor)
{
    // technically not optimized for amd64
    // but there's no way for java to return
    // a value larger than 64-bits
    new (reinterpret_cast<void *>(ret)) sf::Vector3f(sf::Sensor::getValue(
        static_cast<sf::Sensor::Type>(sensor)
    ));
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Touch_1isDown(JNIEnv *, jclass, jint finger)
{
    return static_cast<jboolean>(sf::Touch::isDown(
        static_cast<unsigned int>(finger)
    ));
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Touch_1getPosition__I(JNIEnv *, jclass, jint finger)
{
    sf::Vector2i position = sf::Touch::getPosition(
        static_cast<unsigned int>(finger)
    );

    return static_cast<jlong>(
        ((uint64_t)position.x & 0xffffffff) |
        ((uint64_t)position.y << 32)
    );
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Touch_1getPosition__IJ(JNIEnv *, jclass, jint finger, jlong relativeTo)
{
    sf::Vector2i position = sf::Touch::getPosition(
        static_cast<unsigned int>(finger),
        *reinterpret_cast<sf::Window *>(relativeTo)
    );

    return static_cast<jlong>(
        ((uint64_t)position.x & 0xffffffff) |
        ((uint64_t)position.y << 32)
    );
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1VideoMode_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::VideoMode));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1VideoMode_1VideoMode(JNIEnv *, jclass, jlong this_, jint modeWidth, jint modeHeight, jint modeBitsPerPixel)
{
    new (reinterpret_cast<void *>(this_)) sf::VideoMode(
        static_cast<unsigned int>(modeWidth),
        static_cast<unsigned int>(modeHeight),
        static_cast<unsigned int>(modeBitsPerPixel)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1VideoMode_1getDesktopMode(JNIEnv *, jclass, jlong ret)
{
    new (reinterpret_cast<void *>(ret)) sf::VideoMode(sf::VideoMode::getDesktopMode());
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1VideoMode_1getFullscreenModes(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&sf::VideoMode::getFullscreenModes());
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1VideoMode_1getWidth(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::VideoMode *>(this_)->width);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1VideoMode_1getHeight(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::VideoMode *>(this_)->height);
}

jint Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1VideoMode_1getBitsPerPixel(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::VideoMode *>(this_)->bitsPerPixel);
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(JavaWindow));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1Window__JLorg_sfml_1dev_window_Window_2(JNIEnv *env, jclass, jlong this_, jobject obj)
{
    if (!JavaWindow::env) {
        JavaWindow::env = env;
    }

    new (reinterpret_cast<void *>(this_)) JavaWindow(
        env->NewWeakGlobalRef(obj)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1Window__JLorg_sfml_1dev_window_Window_2JIJIJ(JNIEnv *env, jclass, jlong this_, jobject obj, jlong mode, jint mode1, jlong title, jint style, jlong settings)
{
    if (!JavaWindow::env) {
        JavaWindow::env = env;
    }

    uint8_t cppMode[sizeof(sf::VideoMode)];
    reinterpret_cast<sf::VideoMode *>(cppMode)->width = (uint32_t)mode;
    reinterpret_cast<sf::VideoMode *>(cppMode)->height = (uint32_t)(mode >> 32);
    reinterpret_cast<sf::VideoMode *>(cppMode)->bitsPerPixel = (uint32_t)mode1;

    new (reinterpret_cast<void *>(this_)) JavaWindow(
        env->NewWeakGlobalRef(obj),
        *reinterpret_cast<sf::VideoMode *>(cppMode),
        *reinterpret_cast<sf::String *>(title),
        static_cast<sf::Uint32>(style),
        *reinterpret_cast<sf::ContextSettings *>(settings)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1Window__JLorg_sfml_1dev_window_Window_2JJ(JNIEnv *env, jclass, jlong this_, jobject obj, jlong handle, jlong settings)
{
    if (!JavaWindow::env) {
        JavaWindow::env = env;
    }

    new (reinterpret_cast<void *>(this_)) JavaWindow(
        env->NewWeakGlobalRef(obj),
        *reinterpret_cast<sf::WindowHandle *>(&handle),
        *reinterpret_cast<sf::ContextSettings *>(settings)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1destructor(JNIEnv *, jclass, jlong this_)
{
    reinterpret_cast<JavaWindow *>(this_)->~JavaWindow();
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1create__JJIJIJ(JNIEnv *, jclass, jlong this_, jlong mode, jint mode1, jlong title, jint style, jlong settings)
{
    uint8_t cppMode[sizeof(sf::VideoMode)];
    reinterpret_cast<sf::VideoMode *>(cppMode)->width = (uint32_t)mode;
    reinterpret_cast<sf::VideoMode *>(cppMode)->height = (uint32_t)(mode >> 32);
    reinterpret_cast<sf::VideoMode *>(cppMode)->bitsPerPixel = (uint32_t)mode1;

    reinterpret_cast<sf::Window *>(this_)->create(
        *reinterpret_cast<sf::VideoMode *>(cppMode),
        *reinterpret_cast<sf::String *>(title),
        static_cast<sf::Uint32>(style),
        *reinterpret_cast<sf::ContextSettings *>(settings)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1create__JJJ(JNIEnv *, jclass, jlong this_, jlong handle, jlong settings)
{
    reinterpret_cast<sf::Window *>(this_)->create(
        *reinterpret_cast<sf::WindowHandle *>(&handle),
        *reinterpret_cast<sf::ContextSettings *>(settings)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1close(JNIEnv *, jclass, jlong this_)
{
    reinterpret_cast<sf::Window *>(this_)->close();
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1isOpen(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jboolean>(reinterpret_cast<sf::Window *>(this_)->isOpen());
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1getSettings(JNIEnv *, jclass, jlong this_)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Window *>(this_)->getSettings());
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1pollEvent(JNIEnv *, jclass, jlong this_, jlong event)
{
    return static_cast<jboolean>(reinterpret_cast<sf::Window *>(this_)->pollEvent(
        *reinterpret_cast<sf::Event *>(event)
    ));
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1waitEvent(JNIEnv *, jclass, jlong this_, jlong event)
{
    return static_cast<jboolean>(reinterpret_cast<sf::Window *>(this_)->waitEvent(
        *reinterpret_cast<sf::Event *>(event)
    ));
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1getPosition(JNIEnv *, jclass, jlong this_)
{
    sf::Vector2i position = reinterpret_cast<sf::Window *>(this_)->getPosition();
    return static_cast<jlong>(
        (static_cast<uint64_t>(position.x) & 0xffffffff) | 
        (static_cast<uint64_t>(position.y) << 32));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1setPosition(JNIEnv *, jclass, jlong this_, jlong position)
{
    reinterpret_cast<sf::Window *>(this_)->setPosition(
        *reinterpret_cast<const sf::Vector2i *>(position)
    );
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1getSize(JNIEnv *, jclass, jlong this_)
{
    sf::Vector2u size = reinterpret_cast<sf::Window *>(this_)->getSize();
    return static_cast<jlong>(
        (static_cast<uint64_t>(size.x) & 0xffffffff) | 
        (static_cast<uint64_t>(size.y) << 32));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1setSize(JNIEnv *, jclass, jlong this_, jlong size)
{
    reinterpret_cast<sf::Window *>(this_)->setSize(
        *reinterpret_cast<const sf::Vector2u *>(size)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1setTitle(JNIEnv *, jclass, jlong this_, jlong title)
{
    reinterpret_cast<sf::Window *>(this_)->setTitle(
        *reinterpret_cast<const sf::String *>(title)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1setIcon(JNIEnv *, jclass, jlong this_, jint width, jint height, jlong pixels)
{
    reinterpret_cast<sf::Window *>(this_)->setIcon(
        static_cast<unsigned int>(width),
        static_cast<unsigned int>(height),
        reinterpret_cast<const sf::Uint8 *>(pixels)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1setVisible(JNIEnv *, jclass, jlong this_, jboolean visible)
{
    reinterpret_cast<sf::Window *>(this_)->setVisible(
        static_cast<bool>(visible)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1setVerticalSyncEnabled(JNIEnv *, jclass, jlong this_, jboolean enabled)
{
    reinterpret_cast<sf::Window *>(this_)->setVerticalSyncEnabled(
        static_cast<bool>(enabled)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1setMouseCursorVisible(JNIEnv *, jclass, jlong this_, jboolean visible)
{
    reinterpret_cast<sf::Window *>(this_)->setMouseCursorVisible(
        static_cast<bool>(visible)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1setMouseCursorGrabbed(JNIEnv *, jclass, jlong this_, jboolean grabbed)
{
    reinterpret_cast<sf::Window *>(this_)->setMouseCursorGrabbed(
        static_cast<bool>(grabbed)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1setMouseCursor(JNIEnv *, jclass, jlong this_, jlong cursor)
{
    reinterpret_cast<sf::Window *>(this_)->setMouseCursor(
        *reinterpret_cast<const sf::Cursor *>(cursor)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1setKeyRepeatEnabled(JNIEnv *, jclass, jlong this_, jboolean enabled)
{
    reinterpret_cast<sf::Window *>(this_)->setKeyRepeatEnabled(
        static_cast<bool>(enabled)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1setFramerateLimit(JNIEnv *, jclass, jlong this_, jint limit)
{
    reinterpret_cast<sf::Window *>(this_)->setFramerateLimit(
        static_cast<unsigned int>(limit)
    );
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1setJoystickThreshold(JNIEnv *, jclass, jlong this_, jfloat threshold)
{
    reinterpret_cast<sf::Window *>(this_)->setJoystickThreshold(
        static_cast<float>(threshold)
    );
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1setActive(JNIEnv *, jclass, jlong this_, jboolean active)
{
    return static_cast<jboolean>(reinterpret_cast<sf::Window *>(this_)->setActive(
        static_cast<bool>(active)
    ));
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1requestFocus(JNIEnv *, jclass, jlong this_)
{
    reinterpret_cast<sf::Window *>(this_)->requestFocus();
}

jboolean Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1hasFocus(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jboolean>(reinterpret_cast<sf::Window *>(this_)->hasFocus());
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1display(JNIEnv *, jclass, jlong this_)
{
    reinterpret_cast<sf::Window *>(this_)->display();
}

jlong Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Window_1getSystemHandle(JNIEnv *, jclass, jlong this_)
{
    sf::WindowHandle systemHandle = reinterpret_cast<sf::Window *>(this_)->getSystemHandle();
    return *reinterpret_cast<jlong *>(&systemHandle);
}
