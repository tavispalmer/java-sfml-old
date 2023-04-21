#include "SFML_System.h"
#include <SFML/System.hpp>

jlong Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Clock_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::Clock));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Clock_1Clock(JNIEnv *, jclass, jlong this_)
{
    new (reinterpret_cast<void *>(this_)) sf::Clock;
}

jlong Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Clock_1getElapsedTime(JNIEnv *, jclass, jlong this_)
{
    sf::Time ret = reinterpret_cast<sf::Clock *>(this_)->getElapsedTime();
    return *reinterpret_cast<jlong *>(&ret);
}

jlong Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Clock_1restart(JNIEnv *, jclass, jlong this_)
{
    sf::Time ret = reinterpret_cast<sf::Clock *>(this_)->restart();
    return *reinterpret_cast<jlong *>(&ret);
}

jlong Java_org_sfml_1dev_system_sys_SFML_1System_sf_1String_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::String));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1String_1String(JNIEnv *, jclass, jlong this_)
{
    new (reinterpret_cast<void *>(this_)) sf::String;
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1String_1destructor(JNIEnv *, jclass, jlong this_)
{
    reinterpret_cast<sf::String *>(this_)->~String();
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1String_1fromUtf16(JNIEnv *, jclass, jlong ret, jlong begin, jlong end)
{
    new (reinterpret_cast<void *>(ret)) sf::String(sf::String::fromUtf16(reinterpret_cast<sf::Uint16 *>(begin), reinterpret_cast<sf::Uint16 *>(end)));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1String_1toUtf16(JNIEnv *, jclass, jlong ret, jlong this_)
{
    new (reinterpret_cast<void *>(ret)) std::basic_string<sf::Uint16>(reinterpret_cast<sf::String *>(this_)->toUtf16());
}

jlong Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector2i_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::Vector2i));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector2i_1Vector2i(JNIEnv *, jclass, jlong this_, jint x, jint y)
{
    new (reinterpret_cast<void *>(this_)) sf::Vector2i(
        static_cast<int>(x),
        static_cast<int>(y)
    );
}

jint Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector2i_1getX(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Vector2i *>(this_)->x);
}

jint Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector2i_1getY(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Vector2i *>(this_)->y);
}

jlong Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector2u_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::Vector2u));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector2u_1Vector2u(JNIEnv *, jclass, jlong this_, jint x, jint y)
{
    new (reinterpret_cast<void *>(this_)) sf::Vector2u(
        static_cast<unsigned int>(x),
        static_cast<unsigned int>(y)
    );
}

jint Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector2u_1getX(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Vector2u *>(this_)->x);
}

jint Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector2u_1getY(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Vector2u *>(this_)->y);
}

jlong Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector2f_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::Vector2f));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector2f_1Vector2f(JNIEnv *, jclass, jlong this_, jfloat x, jfloat y)
{
    new (reinterpret_cast<void *>(this_)) sf::Vector2f(
        static_cast<float>(x),
        static_cast<float>(y)
    );
}

jfloat Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector2f_1getX(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::Vector2f *>(this_)->x);
}

jfloat Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector2f_1getY(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::Vector2f *>(this_)->y);
}

jlong Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector3f_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::Vector3f));
}

jfloat Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector3f_1getX(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::Vector3f *>(this_)->x);
}

jfloat Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector3f_1getY(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::Vector3f *>(this_)->y);
}

jfloat Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Vector3f_1getZ(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::Vector3f *>(this_)->z);
}
