#include "SFML_Graphics.h"
#include <SFML/Graphics.hpp>

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1FloatRect_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::FloatRect));
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1FloatRect_1FloatRect(JNIEnv *, jclass, jlong this_, jfloat rectLeft, jfloat rectTop, jfloat rectWidth, jfloat rectHeight)
{
    new (reinterpret_cast<void *>(this_)) sf::FloatRect(
        static_cast<float>(rectLeft),
        static_cast<float>(rectTop),
        static_cast<float>(rectWidth),
        static_cast<float>(rectHeight)
    );
}

jfloat Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1FloatRect_1getLeft(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::FloatRect *>(this_)->left);
}

jfloat Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1FloatRect_1getTop(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::FloatRect *>(this_)->top);
}

jfloat Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1FloatRect_1getWidth(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::FloatRect *>(this_)->width);
}

jfloat Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1FloatRect_1getHeight(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::FloatRect *>(this_)->height);
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::Transform));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1Identity(JNIEnv *, jclass)
{
    return reinterpret_cast<jlong>(&sf::Transform::Identity);
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1Transform__J(JNIEnv *, jclass, jlong this_)
{
    new (reinterpret_cast<void *>(this_)) sf::Transform;
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1Transform__JFFFFFFFFF(JNIEnv *, jclass, jlong this_, jfloat a00, jfloat a01, jfloat a02, jfloat a10, jfloat a11, jfloat a12, jfloat a20, jfloat a21, jfloat a22)
{
    new (reinterpret_cast<void *>(this_)) sf::Transform(
        static_cast<float>(a00),
        static_cast<float>(a01),
        static_cast<float>(a02),
        static_cast<float>(a10),
        static_cast<float>(a11),
        static_cast<float>(a12),
        static_cast<float>(a20),
        static_cast<float>(a21),
        static_cast<float>(a22)
    );
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1Transform__JJ(JNIEnv *, jclass, jlong this_, jlong copy)
{
    new (reinterpret_cast<void *>(this_)) sf::Transform(*reinterpret_cast<sf::Transform *>(copy));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1getMatrix(JNIEnv *, jclass, jlong this_)
{
    return reinterpret_cast<jlong>(reinterpret_cast<sf::Transform *>(this_)->getMatrix());
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1getInverse(JNIEnv *, jclass, jlong ret, jlong this_)
{
    new (reinterpret_cast<void *>(ret)) sf::Transform(reinterpret_cast<sf::Transform *>(this_)->getInverse());
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1transformPoint__JFF(JNIEnv *, jclass, jlong this_, jfloat x, jfloat y)
{
    sf::Vector2f ret = reinterpret_cast<sf::Transform *>(this_)->transformPoint(
        static_cast<float>(x),
        static_cast<float>(y)
    );
    return *reinterpret_cast<jlong *>(&ret);
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1transformPoint__JJ(JNIEnv *, jclass, jlong this_, jlong point)
{
    sf::Vector2f ret = reinterpret_cast<sf::Transform *>(this_)->transformPoint(*reinterpret_cast<sf::Vector2f *>(point));
    return *reinterpret_cast<jlong *>(&ret);
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1transformRect(JNIEnv *, jclass, jlong ret, jlong this_, jlong rectangle)
{
    new (reinterpret_cast<void *>(ret)) sf::FloatRect(reinterpret_cast<sf::Transform *>(this_)->transformRect(*reinterpret_cast<sf::FloatRect *>(rectangle)));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1combine(JNIEnv *, jclass, jlong this_, jlong transform)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transform *>(this_)->combine(*reinterpret_cast<sf::Transform *>(transform)));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1translate__JFF(JNIEnv *, jclass, jlong this_, jfloat x, jfloat y)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transform *>(this_)->translate(
        static_cast<float>(x),
        static_cast<float>(y)));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1translate__JJ(JNIEnv *, jclass, jlong this_, jlong offset)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transform *>(this_)->translate(*reinterpret_cast<sf::Vector2f *>(offset)));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1rotate__JF(JNIEnv *, jclass, jlong this_, jfloat angle)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transform *>(this_)->rotate(static_cast<float>(angle)));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1rotate__JFFF(JNIEnv *, jclass, jlong this_, jfloat angle, jfloat centerX, jfloat centerY)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transform *>(this_)->rotate(
        static_cast<float>(angle),
        static_cast<float>(centerX),
        static_cast<float>(centerY)
    ));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1rotate__JFJ(JNIEnv *, jclass, jlong this_, jfloat angle, jlong center)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transform *>(this_)->rotate(
        static_cast<float>(angle),
        *reinterpret_cast<sf::Vector2f *>(center)
    ));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1scale__JFF(JNIEnv *, jclass, jlong this_, jfloat scaleX, jfloat scaleY)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transform *>(this_)->scale(
        static_cast<float>(scaleX),
        static_cast<float>(scaleY)
    ));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1scale__JFFFF(JNIEnv *, jclass, jlong this_, jfloat scaleX, jfloat scaleY, jfloat centerX, jfloat centerY)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transform *>(this_)->scale(
        static_cast<float>(scaleX),
        static_cast<float>(scaleY),
        static_cast<float>(centerX),
        static_cast<float>(centerY)
    ));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1scale__JJ(JNIEnv *, jclass, jlong this_, jlong factors)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transform *>(this_)->scale(*reinterpret_cast<sf::Vector2f *>(factors)));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1scale__JJJ(JNIEnv *, jclass, jlong this_, jlong factors, jlong center)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transform *>(this_)->scale(
        *reinterpret_cast<sf::Vector2f *>(factors),
        *reinterpret_cast<sf::Vector2f *>(center)
    ));
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_operator_1mul_1_1sf_1Transform_1_1sf_1Transform(JNIEnv *, jclass, jlong ret, jlong left, jlong right)
{
    new (reinterpret_cast<void *>(ret)) sf::Transform(*reinterpret_cast<sf::Transform *>(left) * *reinterpret_cast<sf::Transform *>(right));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_operator_1mul_1_1sf_1Transform_1_1sf_1Vector2f(JNIEnv *, jclass, jlong left, jlong right)
{
    sf::Vector2f ret = *reinterpret_cast<sf::Transform *>(left) * *reinterpret_cast<sf::Vector2f *>(right);
    return *reinterpret_cast<jlong *>(&ret);
}

jboolean Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_operator_1eq_1_1sf_1Transform_1_1sf_1Transform(JNIEnv *, jclass, jlong left, jlong right)
{
    return static_cast<jboolean>(*reinterpret_cast<sf::Transform *>(left) == *reinterpret_cast<sf::Transform *>(right));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(sf::Transformable));
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1Transformable__J(JNIEnv *, jclass, jlong this_)
{
    new (reinterpret_cast<void *>(this_)) sf::Transformable;
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1Transformable__JJ(JNIEnv *, jclass, jlong this_, jlong copy)
{
    new (reinterpret_cast<void *>(this_)) sf::Transformable(*reinterpret_cast<sf::Transformable *>(copy));
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1destructor(JNIEnv *, jclass, jlong this_)
{
    reinterpret_cast<sf::Transformable *>(this_)->~Transformable();
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1setPosition__JFF(JNIEnv *, jclass, jlong this_, jfloat x, jfloat y)
{
    reinterpret_cast<sf::Transformable *>(this_)->setPosition(
        static_cast<float>(x),
        static_cast<float>(y)
    );
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1setPosition__JJ(JNIEnv *, jclass, jlong this_, jlong position)
{
    reinterpret_cast<sf::Transformable *>(this_)->setPosition(*reinterpret_cast<sf::Vector2f *>(position));
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1setRotation(JNIEnv *, jclass, jlong this_, jfloat angle)
{
    reinterpret_cast<sf::Transformable *>(this_)->setRotation(static_cast<float>(angle));
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1setScale__JFF(JNIEnv *, jclass, jlong this_, jfloat factorX, jfloat factorY)
{
    reinterpret_cast<sf::Transformable *>(this_)->setScale(
        static_cast<float>(factorX),
        static_cast<float>(factorY)
    );
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1setScale__JJ(JNIEnv *, jclass, jlong this_, jlong factors)
{
    reinterpret_cast<sf::Transformable *>(this_)->setScale(*reinterpret_cast<sf::Vector2f *>(factors));
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1setOrigin__JFF(JNIEnv *, jclass, jlong this_, jfloat x, jfloat y)
{
    reinterpret_cast<sf::Transformable *>(this_)->setOrigin(
        static_cast<float>(x),
        static_cast<float>(y)
    );
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1setOrigin__JJ(JNIEnv *, jclass, jlong this_, jlong origin)
{
    reinterpret_cast<sf::Transformable *>(this_)->setOrigin(*reinterpret_cast<sf::Vector2f *>(origin));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1getPosition(JNIEnv *, jclass, jlong this_)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transformable *>(this_)->getPosition());
}

jfloat Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1getRotation(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jfloat>(reinterpret_cast<sf::Transformable *>(this_)->getRotation());
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1getScale(JNIEnv *, jclass, jlong this_)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transformable *>(this_)->getScale());
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1getOrigin(JNIEnv *, jclass, jlong this_)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transformable *>(this_)->getOrigin());
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1move__JFF(JNIEnv *, jclass, jlong this_, jfloat offsetX, jfloat offsetY)
{
    reinterpret_cast<sf::Transformable *>(this_)->move(
        static_cast<float>(offsetX),
        static_cast<float>(offsetY)
    );
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1move__JJ(JNIEnv *, jclass, jlong this_, jlong offset)
{
    reinterpret_cast<sf::Transformable *>(this_)->move(*reinterpret_cast<sf::Vector2f *>(offset));
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1rotate(JNIEnv *, jclass, jlong this_, jfloat angle)
{
    reinterpret_cast<sf::Transformable *>(this_)->rotate(static_cast<float>(angle));
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1scale__JFF(JNIEnv *, jclass, jlong this_, jfloat factorX, jfloat factorY)
{
    reinterpret_cast<sf::Transformable *>(this_)->scale(
        static_cast<float>(factorX),
        static_cast<float>(factorY)
    );
}

void Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1scale__JJ(JNIEnv *, jclass, jlong this_, jlong factor)
{
    reinterpret_cast<sf::Transformable *>(this_)->scale(*reinterpret_cast<sf::Vector2f *>(factor));
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1getTransform(JNIEnv *, jclass, jlong this_)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transformable *>(this_)->getTransform());
}

jlong Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transformable_1getInverseTransform(JNIEnv *, jclass, jlong this_)
{
    return reinterpret_cast<jlong>(&reinterpret_cast<sf::Transformable *>(this_)->getInverseTransform());
}
