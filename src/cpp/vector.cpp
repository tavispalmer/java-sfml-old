#include "vector.h"
#include <vector>
#include <SFML/Window.hpp>

jlong Java_org_sfml_1dev_system_sys_vector_std_1vector_1sf_1VideoMode_1begin(JNIEnv *, jclass, jlong this_)
{
    std::vector<sf::VideoMode>::iterator ret = reinterpret_cast<std::vector<sf::VideoMode> *>(this_)->begin();
    return *reinterpret_cast<jlong *>(&ret);
}

jlong Java_org_sfml_1dev_system_sys_vector_std_1vector_1sf_1VideoMode_1end(JNIEnv *, jclass, jlong this_)
{
    std::vector<sf::VideoMode>::iterator ret = reinterpret_cast<std::vector<sf::VideoMode> *>(this_)->end();
    return *reinterpret_cast<jlong *>(&ret);
}
