package org.sfml_dev.window;

import java.util.function.LongConsumer;

import org.sfml_dev.system.*;
import static org.sfml_dev.system.sys.jni.*;
import static org.sfml_dev.window.sys.SFML_Window.*;

public class Cursor extends CppObject {
    
    public enum Type {
        ARROW,
        ARROW_WAIT,
        WAIT,
        TEXT,
        HAND,
        SIZE_HORIZONTAL,
        SIZE_VERTICAL,
        SIZE_TOP_LEFT_BOTTOM_RIGHT,
        SIZE_BOTTOM_LEFT_TOP_RIGHT,
        SIZE_ALL,
        CROSS,
        HELP,
        NOT_ALLOWED
    }

    public Cursor() {
        sf_Cursor_Cursor(getPtr());
    }

    public boolean loadFromPixels(byte[] pixels, Vector2i size, Vector2i hotspot) {
        long elems = GetByteArrayElements(pixels, 0);

        boolean ret = sf_Cursor_loadFromPixels(
            getPtr(),
            elems,
            size.x | (size.y << 32),
            hotspot.x | (hotspot.y << 32)
        );

        ReleaseByteArrayElements(pixels, elems, JNI_ABORT);
        return ret;
    }

    public boolean loadFromSystem(Type type) {
        return sf_Cursor_loadFromSystem(getPtr(), type.ordinal());
    }

    protected long sizeof() {
        return sf_Cursor_sizeof;
    }

    protected LongConsumer getDestructor() {
        return ptr -> sf_Cursor_destructor(ptr);
    }
}
