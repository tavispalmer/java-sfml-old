package org.sfml_dev.graphics;

import org.sfml_dev.system.*;

import static org.sfml_dev.system.sys.jni.*;

import static org.sfml_dev.system.sys.new_.*;
import static org.sfml_dev.system.sys.SFML_System.*;
import static org.sfml_dev.graphics.sys.SFML_Graphics.*;

public class Transform extends CppObject implements Cloneable {
    
    public static final Transform IDENTITY = new ImmutableTransform(sf_Transform_Identity);

    public Transform() {
        sf_Transform_Transform(getPtr());
    }

    public Transform(float a00, float a01, float a02, float a10, float a11, float a12, float a20, float a21, float a22) {
        sf_Transform_Transform(getPtr(), a00, a01, a02, a10, a11, a12, a20, a21, a22);
    }

    Transform(boolean dummy) {
    }

    private Transform(long ptr) {
        super(ptr);
    }

    public float[] getMatrix() {
        float[] matrix = new float[16];
        SetFloatArrayRegion(
            matrix,
            0,
            16,
            sf_Transform_getMatrix(getPtr())
        );
        return matrix;
    }

    public Transform getInverse() {
        Transform inverse = new Transform(false);
        sf_Transform_getInverse(
            inverse.getPtr(),
            this.getPtr()
        );
        return inverse;
    }

    public Vector2f transformPoint(float x, float y) {
        long ret = sf_Transform_transformPoint(getPtr(), x, y);
        return new Vector2f(
            Float.intBitsToFloat((int)ret),
            Float.intBitsToFloat((int)(ret >> 32))
        );
    }

    public Vector2f transformPoint(Vector2f point) {
        long sfPoint = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(sfPoint, point.x, point.y);

        long ret = sf_Transform_transformPoint(
            getPtr(),
            sfPoint
        );

        operator_delete(sfPoint);
        return new Vector2f(
            Float.intBitsToFloat((int)ret),
            Float.intBitsToFloat((int)(ret >> 32))
        );
    }

    public FloatRect transformRect(FloatRect rectangle) {
        long sfRectangle = operator_new(sf_FloatRect_sizeof);
        sf_FloatRect_FloatRect(
            sfRectangle,
            rectangle.left,
            rectangle.top,
            rectangle.width,
            rectangle.height
        );

        long sfRet = operator_new(sf_FloatRect_sizeof);
        sf_Transform_transformRect(sfRet, getPtr(), sfRectangle);

        operator_delete(sfRectangle);

        FloatRect ret = new FloatRect(
            sf_FloatRect_getLeft(sfRet),
            sf_FloatRect_getTop(sfRet),
            sf_FloatRect_getWidth(sfRet),
            sf_FloatRect_getHeight(sfRet)
        );
        operator_delete(sfRet);

        return ret;
    }

    public Transform combine(Transform transform) {
        sf_Transform_combine(getPtr(), transform.getPtr());
        return this;
    }

    public Transform translate(float x, float y) {
        sf_Transform_translate(getPtr(), x, y);
        return this;
    }

    public Transform translate(Vector2f offset) {
        long sfOffset = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(sfOffset, offset.x, offset.y);
        sf_Transform_translate(getPtr(), sfOffset);
        operator_delete(sfOffset);
        return this;
    }

    public Transform rotate(float angle) {
        sf_Transform_rotate(getPtr(), angle);
        return this;
    }

    public Transform rotate(float angle, float centerX, float centerY) {
        sf_Transform_rotate(getPtr(), angle, centerX, centerY);
        return this;
    }

    public Transform rotate(float angle, Vector2f center) {
        long sfCenter = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(sfCenter, center.x, center.y);
        sf_Transform_rotate(getPtr(), angle, sfCenter);
        operator_delete(sfCenter);
        return this;
    }

    public Transform scale(float scaleX, float scaleY) {
        sf_Transform_scale(getPtr(), scaleX, scaleY);
        return this;
    }

    public Transform scale(float scaleX, float scaleY, float centerX, float centerY) {
        sf_Transform_scale(getPtr(), scaleX, scaleY, centerX, centerY);
        return this;
    }

    public Transform scale(Vector2f factors) {
        long sfFactors = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(sfFactors, factors.x, factors.y);
        sf_Transform_scale(getPtr(), sfFactors);
        operator_delete(sfFactors);
        return this;
    }

    public Transform scale(Vector2f factors, Vector2f center) {
        long sfFactors = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(sfFactors, factors.x, factors.y);
        long sfCenter = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(sfCenter, center.x, center.y);
        sf_Transform_scale(getPtr(), sfFactors, sfCenter);
        operator_delete(sfCenter);
        operator_delete(sfFactors);
        return this;
    }

    public Transform multiply(Transform val) {
        Transform ret = new Transform(false);
        operator_mul__sf_Transform__sf_Transform(ret.getPtr(), this.getPtr(), val.getPtr());
        return ret;
    }

    public Vector2f multiply(Vector2f val) {
        long sfVal = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(sfVal, val.x, val.y);
        long ret = operator_mul__sf_Transform__sf_Vector2f(getPtr(), sfVal);
        operator_delete(sfVal);
        
        return new Vector2f(
            Float.intBitsToFloat((int)ret),
            Float.intBitsToFloat((int)(ret >> 32))
        );
    }

    public boolean equals(Object val) {
        if (val instanceof Transform transform) {
            return operator_eq__sf_Transform__sf_Transform(this.getPtr(), transform.getPtr());
        }
        return false;
    }

    public Transform clone() {
        Transform transform = new Transform(false);
        sf_Transform_Transform(transform.getPtr(), getPtr());
        return transform;
    }

    protected long sizeof() {
        return sf_Transform_sizeof;
    }

    private static class ImmutableTransform extends Transform {

        public ImmutableTransform(long ptr) {
            super(ptr);
        }

        public Transform combine(Transform transform) {
            throw new UnsupportedOperationException();
        }

        public Transform translate(float x, float y) {
            throw new UnsupportedOperationException();
        }

        public Transform translate(Vector2f offset) {
            throw new UnsupportedOperationException();
        }

        public Transform rotate(float angle) {
            throw new UnsupportedOperationException();
        }

        public Transform rotate(float angle, float centerX, float centerY) {
            throw new UnsupportedOperationException();
        }

        public Transform rotate(float angle, Vector2f center) {
            throw new UnsupportedOperationException();
        }

        public Transform scale(float scaleX, float scaleY) {
            throw new UnsupportedOperationException();
        }

        public Transform scale(float scaleX, float scaleY, float centerX, float centerY) {
            throw new UnsupportedOperationException();
        }

        public Transform scale(Vector2f factors) {
            throw new UnsupportedOperationException();
        }

        public Transform scale(Vector2f factors, Vector2f center) {
            throw new UnsupportedOperationException();
        }
    }
}
