package org.sfml_dev.window;

import org.sfml_dev.system.Vector2i;
import static org.sfml_dev.window.sys.SFML_Window.*;

public class Touch {
    
    private Touch() {}

    public static boolean isDown(int finger) {
        return sf_Touch_isDown(finger);
    }

    public static Vector2i getPosition(int finger) {
        long sfPosition = sf_Touch_getPosition(finger);
        return new Vector2i(
            (int)sfPosition,
            (int)(sfPosition >> 32)
        );
    }

    public static Vector2i getPosition(int finger, Window relativeTo) {
        long sfPosition = sf_Touch_getPosition(finger, relativeTo.getPtr());
        return new Vector2i(
            (int)sfPosition,
            (int)(sfPosition >> 32)
        );
    }
}
