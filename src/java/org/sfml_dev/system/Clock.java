package org.sfml_dev.system;

import static org.sfml_dev.system.sys.SFML_System.*;

public class Clock extends CppObject {

    private static long SIZEOF = sf_Clock_sizeof();

    public Clock() {
        super(SIZEOF, ptr -> {});
        sf_Clock_Clock(getPtr());
    }

    public Time getElapsedTime() {
        return Time.fromMicroseconds(sf_Clock_getElapsedTime(getPtr()));
    }

    public Time restart() {
        return Time.fromMicroseconds(sf_Clock_restart(getPtr()));
    }
}
