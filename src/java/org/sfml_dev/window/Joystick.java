package org.sfml_dev.window;

import static org.sfml_dev.system.sys.jni.*;
import static org.sfml_dev.system.sys.new_.*;
import static org.sfml_dev.system.sys.SFML_System.*;
import static org.sfml_dev.system.sys.string.*;
import static org.sfml_dev.window.sys.SFML_Window.*;

public class Joystick {
    
    public static final int COUNT = 8;

    public static final int BUTTON_COUNT = 32;

    public static final int AXIS_COUNT = 8;

    public enum Axis {
        X,
        Y,
        Z,
        R,
        U,
        V,
        POV_X,
        POV_Y
    }

    public static class Identification {

        public String name;
        public int vendorId;
        public int productId;

        public Identification() {}

        public String toString() {
            return "{name=" + name +
                    ", vendorId=" + vendorId +
                    ", productId=" + productId + "}";
        }
    }

    private Joystick() {}

    public static boolean isConnected(int joystick) {
        return sf_Joystick_isConnected(joystick);
    }

    public static int getButtonCount(int joystick) {
        return sf_Joystick_getButtonCount(joystick);
    }

    public static boolean hasAxis(int joystick, Axis axis) {
        return sf_Joystick_hasAxis(joystick, axis.ordinal());
    }

    public static boolean isButtonPressed(int joystick, int button) {
        return sf_Joystick_isButtonPressed(joystick, button);
    }

    public static float getAxisPosition(int joystick, Axis axis) {
        return sf_Joystick_getAxisPosition(joystick, axis.ordinal());
    }

    public static Identification getIdentification(int joystick) {
        long sfIdentification = operator_new(sf_Joystick_Identification_sizeof);
        sf_Joystick_getIdentification(sfIdentification, joystick);

        Identification identification = new Identification();

        long sfName = sfIdentification + sf_Joystick_Identification_name;
        long u16Name = operator_new(std_u16string_sizeof);
        sf_String_toUtf16(u16Name, sfName);
        sf_String_destructor(sfName);
        operator_delete(sfName);
        identification.name = NewString(
            std_u16string_data(u16Name),
            (int)std_u16string_size(u16Name)
        );
        std_u16string_destructor(u16Name);
        operator_delete(u16Name);

        identification.vendorId = sf_Joystick_Identification_getVendorId(sfIdentification);
        identification.productId = sf_Joystick_Identification_getProductId(sfIdentification);
        return identification;
    }

    public static void update() {
        sf_Joystick_update();
    }
}
