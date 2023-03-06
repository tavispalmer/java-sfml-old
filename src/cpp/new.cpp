#include "new.h"

jlong Java_org_sfml_1dev_system_sys_new_1_operator_1new(JNIEnv *, jclass, jlong count)
{
    return reinterpret_cast<jlong>(operator new(static_cast<unsigned long>(count)));
}

void Java_org_sfml_1dev_system_sys_new_1_operator_1delete(JNIEnv *, jclass, jlong ptr)
{
    operator delete(reinterpret_cast<void *>(ptr));
}
