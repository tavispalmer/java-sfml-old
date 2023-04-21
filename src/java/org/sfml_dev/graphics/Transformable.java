package org.sfml_dev.graphics;

import java.util.function.LongConsumer;

import org.sfml_dev.system.*;

import static org.sfml_dev.system.sys.new_.*;
import static org.sfml_dev.system.sys.SFML_System.*;
import static org.sfml_dev.graphics.sys.SFML_Graphics.*;

public class Transformable extends CppObject {

    public Transformable() {
        sf_Transformable_Transformable(getPtr());
    }

    public void setPosition(float x, float y) {
        sf_Transformable_setPosition(getPtr(), x, y);
    }

    public void setPosition(Vector2f position) {
        long sfPosition = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(sfPosition, position.x, position.y);
        sf_Transformable_setPosition(getPtr(), sfPosition);
        operator_delete(sfPosition);
    }

    public void setRotation(float angle) {
        sf_Transformable_setRotation(getPtr(), angle);
    }

    public void setScale(float factorX, float factorY) {
        sf_Transformable_setScale(getPtr(), factorX, factorY);
    }

    public void setScale(Vector2f factors) {
        long sfFactors = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(sfFactors, factors.x, factors.y);
        sf_Transformable_setScale(getPtr(), sfFactors);
        operator_delete(sfFactors);
    }

    public void setOrigin(float x, float y) {
        sf_Transformable_setOrigin(getPtr(), x, y);
    }

    public void setOrigin(Vector2f origin) {
        long sfOrigin = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(sfOrigin, origin.x, origin.y);
        sf_Transformable_setOrigin(getPtr(), sfOrigin);
        operator_delete(sfOrigin);
    }

    public Vector2f getPosition() {
        long position = sf_Transformable_getPosition(getPtr());
        return new Vector2f(
            sf_Vector2f_getX(position),
            sf_Vector2f_getY(position)
        );
    }

    public float getRotation() {
        return sf_Transformable_getRotation(getPtr());
    }

    public Vector2f getScale() {
        long scale = sf_Transformable_getScale(getPtr());
        return new Vector2f(
            sf_Vector2f_getX(scale),
            sf_Vector2f_getY(scale)
        );
    }

    public Vector2f getOrigin() {
        long origin = sf_Transformable_getOrigin(getPtr());
        return new Vector2f(
            sf_Vector2f_getX(origin),
            sf_Vector2f_getY(origin)
        );
    }

    public void move(float offsetX, float offsetY) {
        sf_Transformable_move(getPtr(), offsetX, offsetY);
    }

    public void move(Vector2f offset) {
        long sfOffset = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(sfOffset, offset.x, offset.y);
        sf_Transformable_move(getPtr(), sfOffset);
        operator_delete(sfOffset);
    }

    public void rotate(float angle) {
        sf_Transformable_rotate(getPtr(), angle);
    }

    public void scale(float factorX, float factorY) {
        sf_Transformable_scale(getPtr(), factorX, factorY);
    }

    public void scale(Vector2f factor) {
        long sfFactor = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(sfFactor, factor.x, factor.y);
        sf_Transformable_scale(getPtr(), sfFactor);
        operator_delete(sfFactor);
    }

    public Transform getTransform() {
        Transform transform =  new Transform(false);
        sf_Transform_Transform(
            transform.getPtr(),
            sf_Transformable_getTransform(getPtr())
        );
        return transform;
    }

    public Transform getInverseTransform() {
        Transform inverseTransform =  new Transform(false);
        sf_Transform_Transform(
            inverseTransform.getPtr(),
            sf_Transformable_getInverseTransform(getPtr())
        );
        return inverseTransform;
    }

    protected long sizeof() {
        return sf_Transformable_sizeof;
    }

    protected LongConsumer getDestructor() {
        return ptr -> sf_Transformable_destructor(ptr);
    }
}
