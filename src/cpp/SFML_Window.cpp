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

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Clipboard_1getString(JNIEnv *, jclass, jlong ret)
{
    new (reinterpret_cast<void *>(ret)) sf::String(sf::Clipboard::getString());
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Clipboard_1setString(JNIEnv *, jclass, jlong text)
{
    sf::Clipboard::setString(*reinterpret_cast<sf::String *>(text));
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
