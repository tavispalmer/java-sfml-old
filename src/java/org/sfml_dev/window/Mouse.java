package org.sfml_dev.window;

import org.sfml_dev.system.Vector2i;
import static org.sfml_dev.system.sys.new_.*;
import static org.sfml_dev.system.sys.SFML_System.*;
import static org.sfml_dev.window.sys.SFML_Window.*;

public class Mouse {
    
    public enum Button {
        LEFT,
        RIGHT,
        MIDDLE,
        X_BUTTON_1,
        X_BUTTON_2
    }

    public enum Wheel {
        VERTICAL_WHEEL,
        HORIZONTAL_WHEEL
    }

    private Mouse() {}

    public static boolean isButtonPressed(Button button) {
        return sf_Mouse_isButtonPressed(button.ordinal());
    }

    public static Vector2i getPosition() {
        long sfPosition = sf_Mouse_getPosition();
        return new Vector2i(
            (int)sfPosition,
            (int)(sfPosition >> 32)
        );
    }

    public static Vector2i getPosition(Window relativeTo) {
        long sfPosition = sf_Mouse_getPosition(relativeTo.getPtr());
        return new Vector2i(
            (int)sfPosition,
            (int)(sfPosition >> 32)
        );
    }

    public static void setPosition(Vector2i position) {
        long sfPosition = operator_new(sf_Vector2i_sizeof);
        sf_Vector2i_Vector2i(sfPosition, position.x, position.y);

        sf_Mouse_setPosition(sfPosition);

        operator_delete(sfPosition);
    }

    public static void setPosition(Vector2i position, Window relativeTo) {
        long sfPosition = operator_new(sf_Vector2i_sizeof);
        sf_Vector2i_Vector2i(sfPosition, position.x, position.y);

        sf_Mouse_setPosition(sfPosition, relativeTo.getPtr());

        operator_delete(sfPosition);
    }
}
