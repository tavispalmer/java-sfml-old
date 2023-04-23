#include "SFML_System.h"
#include <SFML/System.hpp>

jlong Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Clock_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::Clock));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Clock_1Clock__J(JNIEnv *, jclass, jlong this_)
{
    new (reinterpret_cast<void *>(this_)) sf::Clock;
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Clock_1Clock__JJ(JNIEnv *, jclass, jlong this_, jlong copy)
{
    new (reinterpret_cast<void *>(this_)) sf::Clock(*reinterpret_cast<sf::Clock *>(copy));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Clock_1getElapsedTime(JNIEnv *, jclass, jlong ret, jlong this_)
{
    new (reinterpret_cast<void *>(ret)) sf::Time(reinterpret_cast<sf::Clock *>(this_)->getElapsedTime());
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Clock_1restart(JNIEnv *, jclass, jlong ret, jlong this_)
{
    new (reinterpret_cast<void *>(ret)) sf::Time(reinterpret_cast<sf::Clock *>(this_)->restart());
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

jlong Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Time_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::Time));
}

jlong Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Time_1Zero(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&sf::Time::Zero);
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Time_1Time__J(JNIEnv *, jclass, jlong this_)
{
    new (reinterpret_cast<void *>(this_)) sf::Time;
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Time_1Time__JJ(JNIEnv *, jclass, jlong this_, jlong copy)
{
    new (reinterpret_cast<void *>(this_)) sf::Time(*reinterpret_cast<sf::Time *>(copy));
}

jfloat Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Time_1asSeconds(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::Time *>(this_)->asSeconds());
}

jint Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Time_1asMilliseconds(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jint>(reinterpret_cast<sf::Time *>(this_)->asMilliseconds());
}

jlong Java_org_sfml_1dev_system_sys_SFML_1System_sf_1Time_1asMicroseconds(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jlong>(reinterpret_cast<sf::Time *>(this_)->asMicroseconds());
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1seconds(JNIEnv *, jclass, jlong ret, jfloat amount)
{
    new (reinterpret_cast<void *>(ret)) sf::Time(sf::seconds(static_cast<float>(amount)));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1milliseconds(JNIEnv *, jclass, jlong ret, jint amount)
{
    new (reinterpret_cast<void *>(ret)) sf::Time(sf::milliseconds(static_cast<sf::Int32>(amount)));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_sf_1microseconds(JNIEnv *, jclass, jlong ret, jlong amount)
{
    new (reinterpret_cast<void *>(ret)) sf::Time(sf::microseconds(static_cast<sf::Int64>(amount)));
}

jboolean Java_org_sfml_1dev_system_sys_SFML_1System_operator_1eq_1_1sf_1Time(JNIEnv *, jclass, jlong left, jlong right)
{
    return static_cast<jboolean>(*reinterpret_cast<sf::Time *>(left) == *reinterpret_cast<sf::Time *>(right));
}

jboolean Java_org_sfml_1dev_system_sys_SFML_1System_operator_1lt_1_1sf_1Time(JNIEnv *, jclass, jlong left, jlong right)
{
    return static_cast<jboolean>(*reinterpret_cast<sf::Time *>(left) < *reinterpret_cast<sf::Time *>(right));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_operator_1neg_1_1sf_1Time(JNIEnv *, jclass, jlong ret, jlong right)
{
    new (reinterpret_cast<void *>(ret)) sf::Time(-*reinterpret_cast<sf::Time *>(right));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_operator_1add_1_1sf_1Time(JNIEnv *, jclass, jlong ret, jlong left, jlong right)
{
    new (reinterpret_cast<void *>(ret)) sf::Time(*reinterpret_cast<sf::Time *>(left) + *reinterpret_cast<sf::Time *>(right));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_operator_1sub_1_1sf_1Time(JNIEnv *, jclass, jlong ret, jlong left, jlong right)
{
    new (reinterpret_cast<void *>(ret)) sf::Time(*reinterpret_cast<sf::Time *>(left) - *reinterpret_cast<sf::Time *>(right));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_operator_1mul_1_1sf_1Time__JJF(JNIEnv *, jclass, jlong ret, jlong left, jfloat right)
{
    new (reinterpret_cast<void *>(ret)) sf::Time(*reinterpret_cast<sf::Time *>(left) * static_cast<float>(right));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_operator_1mul_1_1sf_1Time__JJJ(JNIEnv *, jclass, jlong ret, jlong left, jlong right)
{
    new (reinterpret_cast<void *>(ret)) sf::Time(*reinterpret_cast<sf::Time *>(left) * static_cast<sf::Int64>(right));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_operator_1div_1_1sf_1Time__JJF(JNIEnv *, jclass, jlong ret, jlong left, jfloat right)
{
    new (reinterpret_cast<void *>(ret)) sf::Time(*reinterpret_cast<sf::Time *>(left) / static_cast<float>(right));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_operator_1div_1_1sf_1Time__JJJ(JNIEnv *, jclass, jlong ret, jlong left, jlong right)
{
    new (reinterpret_cast<void *>(ret)) sf::Time(*reinterpret_cast<sf::Time *>(left) / static_cast<sf::Int64>(right));
}

jfloat Java_org_sfml_1dev_system_sys_SFML_1System_operator_1div_1_1sf_1Time__JJ(JNIEnv *, jclass, jlong left, jlong right)
{
    return static_cast<jfloat>(*reinterpret_cast<sf::Time *>(left) / *reinterpret_cast<sf::Time *>(right));
}

void Java_org_sfml_1dev_system_sys_SFML_1System_operator_1rem_1_1sf_1Time(JNIEnv *, jclass, jlong ret, jlong left, jlong right)
{
    new (reinterpret_cast<void *>(ret)) sf::Time(*reinterpret_cast<sf::Time *>(left) % *reinterpret_cast<sf::Time *>(right));
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
