package org.sfml_dev.window;

import org.sfml_dev.system.Vector2i;
import static org.sfml_dev.system.sys.new_.*;
import static org.sfml_dev.system.sys.SFML_System.*;
import static org.sfml_dev.window.sys.SFML_Window.*;

public class Touch {
    
    private Touch() {}

    public static boolean isDown(int finger) {
        return sf_Touch_isDown(finger);
    }

    public static Vector2i getPosition(int finger) {
        long sfPosition = operator_new(sf_Vector2i_sizeof);

        sf_Touch_getPosition(sfPosition, finger);

        Vector2i position = new Vector2i(
            sf_Vector2i_getX(sfPosition),
            sf_Vector2i_getY(sfPosition)
        );
        operator_delete(sfPosition);
        return position;
    }

    public static Vector2i getPosition(int finger, Window relativeTo) {
        long sfPosition = operator_new(sf_Vector2i_sizeof);

        sf_Touch_getPosition(sfPosition, finger, relativeTo.getPtr());

        Vector2i position = new Vector2i(
            sf_Vector2i_getX(sfPosition),
            sf_Vector2i_getY(sfPosition)
        );
        operator_delete(sfPosition);
        return position;
    }
}
