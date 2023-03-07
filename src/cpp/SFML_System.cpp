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
