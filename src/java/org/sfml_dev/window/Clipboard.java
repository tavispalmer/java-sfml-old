package org.sfml_dev.window;

import static org.sfml_dev.system.sys.jni.*;
import static org.sfml_dev.system.sys.new_.*;
import static org.sfml_dev.system.sys.SFML_System.*;
import static org.sfml_dev.system.sys.string.*;
import static org.sfml_dev.window.sys.SFML_Window.*;

public class Clipboard {

    private Clipboard() {}

    public static String getString() {
        long sfString = operator_new(sf_String_sizeof);
        sf_Clipboard_getString(sfString);

        long u16String = operator_new(std_u16string_sizeof);
        sf_String_toUtf16(u16String, sfString);

        sf_String_destructor(sfString);
        operator_delete(sfString);

        String jString = NewString(std_u16string_data(u16String), (int)std_u16string_size(u16String));
        std_u16string_destructor(u16String);
        operator_delete(u16String);

        return jString;
    }

    public static void setString(String text) {
        if (text != null) {
            long u16String = GetStringChars(text, 0);

            long sfString = operator_new(sf_String_sizeof);
            sf_String_fromUtf16(sfString, u16String, u16String + text.length() * 2);

            ReleaseStringChars(text, u16String);

            sf_Clipboard_setString(sfString);
            sf_String_destructor(sfString);
            operator_delete(sfString);
        }
        else {
            long sfString = operator_new(sf_String_sizeof);
            sf_String_String(sfString);
            sf_Clipboard_setString(sfString);
            sf_String_destructor(sfString);
            operator_delete(sfString);
        }
    }
}
