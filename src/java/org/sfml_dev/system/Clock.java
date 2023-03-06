package org.sfml_dev.system;

import static org.sfml_dev.system.sys.SFML_System.*;

public class Clock extends CppObject {

    public Clock() {
        super(sf_Clock_sizeof(), ptr -> {});
        sf_Clock_Clock(getPtr());
    }

    public Time getElapsedTime() {
        return Time.fromMicroseconds(sf_Clock_getElapsedTime(getPtr()));
    }

    public Time restart() {
        return Time.fromMicroseconds(sf_Clock_restart(getPtr()));
    }
}
