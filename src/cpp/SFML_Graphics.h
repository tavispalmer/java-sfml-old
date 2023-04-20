/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_sfml_dev_graphics_sys_SFML_Graphics */

#ifndef _Included_org_sfml_dev_graphics_sys_SFML_Graphics
#define _Included_org_sfml_dev_graphics_sys_SFML_Graphics
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_FloatRect_sizeof
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1FloatRect_1sizeof
  (JNIEnv *, jclass);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_FloatRect_FloatRect
 * Signature: (JFFFF)V
 */
JNIEXPORT void JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1FloatRect_1FloatRect
  (JNIEnv *, jclass, jlong, jfloat, jfloat, jfloat, jfloat);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_FloatRect_getLeft
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1FloatRect_1getLeft
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_FloatRect_getTop
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1FloatRect_1getTop
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_FloatRect_getWidth
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1FloatRect_1getWidth
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_FloatRect_getHeight
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1FloatRect_1getHeight
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_sizeof
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1sizeof
  (JNIEnv *, jclass);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_Transform
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1Transform__J
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_Transform
 * Signature: (JFFFFFFFFF)V
 */
JNIEXPORT void JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1Transform__JFFFFFFFFF
  (JNIEnv *, jclass, jlong, jfloat, jfloat, jfloat, jfloat, jfloat, jfloat, jfloat, jfloat, jfloat);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_getMatrix
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1getMatrix
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_getInverse
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1getInverse
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_transformPoint
 * Signature: (JFF)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1transformPoint__JFF
  (JNIEnv *, jclass, jlong, jfloat, jfloat);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_transformPoint
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1transformPoint__JJ
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_transformRect
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1transformRect
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_combine
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1combine
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_translate
 * Signature: (JFF)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1translate__JFF
  (JNIEnv *, jclass, jlong, jfloat, jfloat);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_translate
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1translate__JJ
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_rotate
 * Signature: (JF)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1rotate__JF
  (JNIEnv *, jclass, jlong, jfloat);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_rotate
 * Signature: (JFFF)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1rotate__JFFF
  (JNIEnv *, jclass, jlong, jfloat, jfloat, jfloat);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_rotate
 * Signature: (JFJ)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1rotate__JFJ
  (JNIEnv *, jclass, jlong, jfloat, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_scale
 * Signature: (JFF)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1scale__JFF
  (JNIEnv *, jclass, jlong, jfloat, jfloat);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_scale
 * Signature: (JFFFF)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1scale__JFFFF
  (JNIEnv *, jclass, jlong, jfloat, jfloat, jfloat, jfloat);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_scale
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1scale__JJ
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    sf_Transform_scale
 * Signature: (JJJ)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_sf_1Transform_1scale__JJJ
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    operator_mul__sf_Transform__sf_Transform
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_operator_1mul_1_1sf_1Transform_1_1sf_1Transform
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    operator_mul__sf_Transform__sf_Vector2f
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_operator_1mul_1_1sf_1Transform_1_1sf_1Vector2f
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     org_sfml_dev_graphics_sys_SFML_Graphics
 * Method:    operator_eq__sf_Transform__sf_Transform
 * Signature: (JJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_sfml_1dev_graphics_sys_SFML_1Graphics_operator_1eq_1_1sf_1Transform_1_1sf_1Transform
  (JNIEnv *, jclass, jlong, jlong);

#ifdef __cplusplus
}
#endif
#endif