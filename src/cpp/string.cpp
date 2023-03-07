#include "string.h"
#include <string>

jlong Java_org_sfml_1dev_system_sys_string_std_1u16string_1sizeof(JNIEnv *, jclass)
{
    return static_cast<jlong>(sizeof(std::u16string));
}

void Java_org_sfml_1dev_system_sys_string_std_1u16string_1destructor(JNIEnv *, jclass, jlong this_)
{
    reinterpret_cast<std::u16string *>(this_)->~basic_string();
}

jlong Java_org_sfml_1dev_system_sys_string_std_1u16string_1data(JNIEnv *, jclass, jlong this_)
{
    return reinterpret_cast<jlong>(reinterpret_cast<std::u16string *>(this_)->data());
}

jlong Java_org_sfml_1dev_system_sys_string_std_1u16string_1size(JNIEnv *, jclass, jlong this_)
{
    return static_cast<jlong>(reinterpret_cast<std::u16string *>(this_)->size());
}
