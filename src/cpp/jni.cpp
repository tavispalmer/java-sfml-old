#include "jni.h"

jstring Java_org_sfml_1dev_system_sys_jni_NewString(JNIEnv *env, jclass, jlong unicodeChars, jint len)
{
    return env->NewString(
        reinterpret_cast<const jchar *>(unicodeChars),
        static_cast<jsize>(len)
    );
}

jlong Java_org_sfml_1dev_system_sys_jni_GetStringChars(JNIEnv *env, jclass, jstring string, jlong isCopy)
{
    return reinterpret_cast<jlong>(env->GetStringChars(
        string,
        reinterpret_cast<jboolean *>(isCopy)
    ));
}

void Java_org_sfml_1dev_system_sys_jni_ReleaseStringChars(JNIEnv *env, jclass, jstring string, jlong chars)
{
    env->ReleaseStringChars(
        string,
        reinterpret_cast<const jchar *>(chars)
    );
}

jlong Java_org_sfml_1dev_system_sys_jni_GetByteArrayElements(JNIEnv *env, jclass, jbyteArray array, jlong isCopy)
{
    return reinterpret_cast<jlong>(env->GetByteArrayElements(
        array,
        reinterpret_cast<jboolean *>(isCopy)
    ));
}

void Java_org_sfml_1dev_system_sys_jni_ReleaseByteArrayElements(JNIEnv *env, jclass, jbyteArray array, jlong elems, jint mode)
{
    env->ReleaseByteArrayElements(
        array,
        reinterpret_cast<jbyte *>(elems),
        mode
    );
}

void Java_org_sfml_1dev_system_sys_jni_SetFloatArrayRegion(JNIEnv *env, jclass, jfloatArray array, jint start, jint len, jlong buf)
{
    env->SetFloatArrayRegion(
        array,
        start,
        len,
        reinterpret_cast<const jfloat *>(buf)
    );
}
