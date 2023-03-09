package org.sfml_dev.window;

import org.sfml_dev.system.Vector3f;
import static org.sfml_dev.system.sys.new_.*;
import static org.sfml_dev.system.sys.SFML_System.*;
import static org.sfml_dev.window.sys.SFML_Window.*;

public class Sensor {
    
    public enum Type {
        ACCELEROMETER,
        GYROSCOPE,
        MAGNETOMETER,
        GRAVITY,
        USER_ACCELERATION,
        ORIENTATION
    }

    private Sensor() {}

    public static boolean isAvailable(Type sensor) {
        return sf_Sensor_isAvailable(sensor.ordinal());
    }

    public static void setEnabled(Type sensor, boolean enabled) {
        sf_Sensor_setEnabled(sensor.ordinal(), enabled);
    }

    public static Vector3f getValue(Type sensor) {
        long sfValue = operator_new(sf_Vector3f_sizeof);
        sf_Sensor_getValue(sfValue, sensor.ordinal());

        Vector3f value = new Vector3f(
            sf_Vector3f_getX(sfValue),
            sf_Vector3f_getY(sfValue),
            sf_Vector3f_getZ(sfValue)
        );

        operator_delete(sfValue);
        return value;
    }
}
