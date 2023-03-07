#include "SFML_Window.h"
#include <SFML/Window.hpp>

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Clipboard_1getString(JNIEnv *, jclass, jlong ret)
{
    new (reinterpret_cast<void *>(ret)) sf::String(sf::Clipboard::getString());
}

void Java_org_sfml_1dev_window_sys_SFML_1Window_sf_1Clipboard_1setString(JNIEnv *, jclass, jlong text)
{
    sf::Clipboard::setString(*reinterpret_cast<sf::String *>(text));
}
