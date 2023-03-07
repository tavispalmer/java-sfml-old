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
